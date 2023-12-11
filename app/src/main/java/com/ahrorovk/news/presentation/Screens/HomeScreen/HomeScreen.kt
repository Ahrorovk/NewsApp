package com.ahrorovk.news.presentation.Screens.HomeScreen

import android.annotation.SuppressLint
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ahrorovk.news.core.getCategories
import com.ahrorovk.news.core.getErrorIndicator
import com.ahrorovk.news.core.getRetryText
import com.ahrorovk.news.core.getSimpleErrorIndicator
import com.ahrorovk.news.presentation.Screens.HomeScreen.components.CustomCategoryItem
import com.ahrorovk.news.presentation.Screens.HomeScreen.components.CustomTextField
import com.ahrorovk.news.presentation.Screens.InfoScreen.components.ErrorIndicator
import com.ahrorovk.news.presentation.Screens.InfoScreen.components.LoadingIndicator
import com.ahrorovk.news.presentation.Screens.MainViewModel
import com.ahrorovk.news.presentation.Screens.NewsScreen.components.CustomGNewsScreenBox
import com.ahrorovk.news.presentation.ads.showInterstitial
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnrememberedMutableState", "CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    navigateToNews: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current


    val state = rememberSwipeRefreshState(viewModel.stateGetGNews.value.isLoading)

    val stateGetGNews = viewModel.stateGetGNews

    val stateOfCategory = viewModel.stateOfCategory

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
                Column(
                    Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CustomTextField(
                        value = searchTextField,
                        setSearch = {
                            if (it == "") {
                                viewModel.clearNews()
                            }
                            viewModel.setSearch(it)
                        },
                        placeholder = if (viewModel.stateLanguage.value == "ru") "Поиск новостей" else "Search news"
                    ) {
                        viewModel.getGNews(
                            search = searchTextField.trim(),
                            viewModel.stateLanguage.value,
                            context
                        ) {
                            showInterstitial(context) {}
                        }
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    LazyRow(modifier = Modifier.padding(end = 10.dp)) {
                        items(getCategories(viewModel.stateLanguage.value)) { title ->
                            CustomCategoryItem(
                                title = title,
                                isSelected = title == stateOfCategory.value,
                                onClick = {
                                    if (stateOfCategory.value == it) {
                                        viewModel.changeStateOfCategory("")
                                        viewModel.clearNews()
                                    } else {
                                        showInterstitial(context) {}
                                        viewModel.changeStateOfCategory(it)
                                        if (stateOfCategory.value.isNotEmpty()) {
                                            viewModel.getGNews(
                                                search = stateOfCategory.value +
                                                        if (searchTextField.isNotEmpty()) ": $searchTextField"
                                                        else "",
                                                viewModel.stateLanguage.value,
                                                context
                                            )
                                        }
                                    }
                                }
                            )
                            Spacer(modifier = Modifier.padding(5.dp))
                        }
                    }
                }
            }
            Spacer(Modifier.padding(vertical = 3.dp))
            ErrorIndicator(
                error = getErrorIndicator(viewModel),
                onRetryClick = {
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.getGNews(
                            search = searchTextField.trim(),
                            viewModel.stateLanguage.value,
                            context
                        )
                    }
                },
                onRetryText = getRetryText(viewModel)
            )

            if (stateOfCategory.value.isEmpty() && searchTextField.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = getSimpleErrorIndicator(viewModel)),
                        modifier = Modifier.fillMaxWidth(),
                        contentDescription = null
                    )
                }
            }
            LoadingIndicator(isLoading = stateGetGNews.value.isLoading)

            getGNews?.let { newsNonNull ->
                SwipeRefresh(
                    modifier = Modifier.fillMaxSize(),
                    state = state,
                    onRefresh = {
                        coroutineScope.launch {
                            if (searchTextField.isNotEmpty() || stateOfCategory.value.isNotEmpty()) {
                                viewModel.getGNews(
                                    search = searchTextField,
                                    viewModel.stateLanguage.value,
                                    context
                                )
                            } else {
                                Toast.makeText(
                                    context,
                                    if (viewModel.stateLanguage.value == "ru") "Введите запрос" else "Enter a request",
                                    Toast.LENGTH_SHORT
                                ).show()
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
                                    date = it.publishedAt,
                                    title = it.title,
                                    imageUrl = it.image,
                                    content = it.description,
                                ) {
                                    viewModel.changeCurrentSourceNameState(it.source.name)
                                    viewModel.changeCurrentUrlState(it.url)
                                    navigateToNews.invoke()
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}