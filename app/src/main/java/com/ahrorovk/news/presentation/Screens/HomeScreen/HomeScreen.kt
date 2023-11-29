package com.ahrorovk.news.presentation.Screens.HomeScreen

import android.annotation.SuppressLint
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ahrorovk.news.presentation.Screens.CurrencyScreen.components.CustomGNewsScreenBox
import com.ahrorovk.news.presentation.Screens.HomeScreen.components.CustomTextField
import com.ahrorovk.news.presentation.Screens.InfoScreen.components.ErrorIndicator
import com.ahrorovk.news.presentation.Screens.InfoScreen.components.LoadingIndicator
import com.ahrorovk.news.presentation.Screens.MainViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnrememberedMutableState", "CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(viewModel: MainViewModel) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current


    val state = rememberSwipeRefreshState(viewModel.stateGetGNews.value.isLoading)

    val stateGetGNews = viewModel.stateGetGNews

    val getGNews = stateGetGNews.value.response

    val searchTextField = viewModel.searchTextField

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Spacer(Modifier.padding(vertical = 10.dp))
            Row(
                Modifier
                    .padding(start = 10.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                CustomTextField(
                    value = searchTextField,
                    setSearch = {
                        if (it == "---") {
                            viewModel.clearNews()
                        }
                        viewModel.setSearch(if (it == "---") "" else it)
                    },
                    placeholder = if (viewModel.stateLanguage.value == "ru") "Поиск новостей" else "Search news"
                ) {
                    viewModel.getGNews(
                        search = searchTextField.trim(),
                        viewModel.stateLanguage.value,
                        context
                    )
                }
            }
            Spacer(Modifier.padding(vertical = 3.dp))
            ErrorIndicator(
                error = if (stateGetGNews.value.error == "HTTP 400" && searchTextField.isEmpty()) {
                    if (viewModel.stateLanguage.value == "ru") "Введите запрос" else "Enter your request"
                } else if (stateGetGNews.value.response?.articles?.isEmpty() == true && stateGetGNews.value.response?.totalArticles == 0) {
                    if (viewModel.stateLanguage.value == "ru") " Ничего не найдено" else " Nothing found"
                } else stateGetGNews.value.error,
                onRetryClick = {
                    coroutineScope.launch {
                        viewModel.getGNews(
                            search = searchTextField.trim(),
                            viewModel.stateLanguage.value,
                            context
                        )
                    }
                },
                onRetryText = if (viewModel.stateLanguage.value == "ru") "Повторить попытку" else "Try again"
            )

            ErrorIndicator(
                error = if (searchTextField.isEmpty()) {
                    if (viewModel.stateLanguage.value == "ru") "Вы можете найти новости в реальном времени." else "You can find real time news."
                } else "", showButton = false
            )
            LoadingIndicator(isLoading = stateGetGNews.value.isLoading)

            getGNews?.let { newsNonNull ->
                SwipeRefresh(
                    modifier = Modifier.fillMaxSize(),
                    state = state,
                    onRefresh = {
                        coroutineScope.launch {
                            if (searchTextField.isNotEmpty()) {
                                viewModel.getGNews(
                                    search = searchTextField,
                                    viewModel.stateLanguage.value,
                                    context
                                )
                            } else {
                                Toast.makeText(context, "Введите запрос", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                ) {

                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp, horizontal = 5.dp)
                    ) {
                        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
                            items(newsNonNull.articles) {
                                CustomGNewsScreenBox(
                                    author = it.source.name,
                                    time = it.url,
                                    date = it.publishedAt,
                                    title = it.title,
                                    imageUrl = it.image,
                                    content = it.description,
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}