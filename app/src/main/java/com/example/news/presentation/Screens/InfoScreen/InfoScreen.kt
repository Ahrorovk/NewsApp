package com.example.news.presentation.Screens.InfoScreen

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.news.presentation.Screens.HomeScreen.components.ListOfCategory
import com.example.news.presentation.Screens.InfoScreen.components.CustomInfoScreenBox
import com.example.news.presentation.Screens.InfoScreen.components.LoadingIndicator
import com.example.news.presentation.Screens.MainViewModel
import com.example.news.domain.NewsDatabase.NewsDao
import com.example.news.domain.NewsDatabase.NewsDatabase
import com.example.news.presentation.Screens.InfoScreen.components.ErrorIndicator
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@SuppressLint("UnrememberedMutableState")
@Composable
fun InfoScreen(navController: NavController,context:Context,viewModel: MainViewModel) {
    val stateGetNewsAndroid = viewModel.stateGetNewsAndroid
    val state = rememberSwipeRefreshState(stateGetNewsAndroid.value.isLoading)
    val getNewsFromServer = stateGetNewsAndroid.value.response

    val category = viewModel.category
    val iconFavoriteBool = viewModel.iconFavoriteBool
    val iconBookMarkBool = viewModel.iconBookMarkBool
    val saveDeleteBool = viewModel.saveDeleteBool
    val colorOfIconFavorite = viewModel.colorOfIconFavorite
    val colorOfIconBookMark = viewModel.colorOfIconBookMark
    val error = viewModel.error
    var counterOfIconFavorite = 0
    var counterOfIconBookMark = 0
    var new = viewModel.news
    val listOfCategory = listOf(
        ListOfCategory.ANDROID,
        ListOfCategory.IOS,
        ListOfCategory.APPLE,
        ListOfCategory.SAMSUNG,
        ListOfCategory.TECHNOLOGY,
        ListOfCategory.AMAZON,
        ListOfCategory.SCIENCE,
        ListOfCategory.CARS,
        ListOfCategory.HONDA,
        ListOfCategory.BMW,
        ListOfCategory.MERCEDES,
        ListOfCategory.USA,
        ListOfCategory.EUROPE
    )

    LaunchedEffect(key1 = true) {
        val newsDatabase = NewsDatabase.getInstance(context = context)
        val dao: NewsDao = newsDatabase.getDao()
        viewModel.dao = dao
        viewModel.getAllNews()
    }

    /*val listOfGet = listOf(
        viewModel.getNewsAndroid(),
        viewModel.getNewsIos(),
        viewModel.getNewsApple(),
        viewModel.getNewsSamsung(),
        viewModel.getNewsTechnology(),
        viewModel.getNewsScience(),
        viewModel.getNewsCars(),
        viewModel.getNewsHonda(),
        viewModel.getNewsBmw(),
        viewModel.getNewsMercedes(),
        viewModel.getNewsUsa(),
        viewModel.getNewsEurope(),
    )*/
    if (error.isNotEmpty()) {
        Text(error)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFFCFCFCF)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                    Spacer(modifier = Modifier.padding(45.dp))
                    Text("News of $category")
                }
            }
        }) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFEFEFE))
        ) {
            Spacer(modifier = Modifier.padding(vertical = 6.dp))
            getNewsFromServer?.let { newsNonNull ->

                SwipeRefresh(
                    modifier = Modifier.fillMaxSize(),
                    state = state,
                    onRefresh = {
                        viewModel.getNewsAndroid(category, context)
                    }
                ) {

                    LazyColumn() {
                        items(newsNonNull) { news ->
                            CustomInfoScreenBox(
                                author = news.author ?: "Загрузка",
                                time = news.time ?: "Загрузка",
                                date = news.date ?: "Загрузка",
                                title = news.title ?: "Загрузка",
                                imageUrl = news.imageUrl ?: "Загрузка",
                                content = news.content ?: "Загрузка",
                                IconFavoriteOnClick = {
                                    counterOfIconFavorite++
                                    viewModel.setCountIConFavoriteClick(counterOfIconFavorite)
                                },
                                colorOfIconFavorite = colorOfIconFavorite.value,
                                IconFavoriteBool = iconFavoriteBool.value,
                                IconSaveOnClick = {
                                    counterOfIconBookMark++
                                    viewModel.getNews(
                                        news.title,
                                        news.content,
                                        news.author,
                                        news.date,
                                        news.time,
                                        news.imageUrl,
                                        counterOfIconBookMark
                                    )
                                    viewModel.setCountIconBookMarkClick(counterOfIconBookMark)
                                },
                                colorOfIconBookMark = colorOfIconBookMark.value,
                                IconBookMarkBool = iconBookMarkBool.value,
                                IconDeleteOnClick = {
                                    this@LazyColumn.items(new) { new ->
                                        viewModel.deleteNote(new.id)
                                    }
                                    counterOfIconBookMark++
                                    viewModel.setCountIconBookMarkClick(counterOfIconBookMark)
                                },
                                SaveDeleteBool = saveDeleteBool.value,
                                onClick = {}
                                )
                            Spacer(modifier = Modifier.padding(6.dp))
                        }
                    }
                }
            }
        }
        LoadingIndicator(isLoading = stateGetNewsAndroid.value.isLoading)
        ErrorIndicator(
            error = stateGetNewsAndroid.value.error,
            onRetryClick = { viewModel.getNewsAndroid(technology = category,context) },
        onRetryText = "Повторить попытку")
    }
}