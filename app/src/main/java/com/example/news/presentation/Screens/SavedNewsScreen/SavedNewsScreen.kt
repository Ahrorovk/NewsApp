package com.example.news.presentation.Screens

import android.content.Context
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.news.Constants.bool
import com.example.news.presentation.Screens.HomeScreen.components.HomeScreenTopAppBar
import com.example.news.presentation.Screens.InfoScreen.components.CustomInfoScreenBox
import com.example.news.domain.NewsDatabase.NewsDao
import com.example.news.domain.NewsDatabase.NewsDatabase

@Composable
fun SavedNewsScreen(navController: NavController, context:Context, viewModel: MainViewModel) {
    bool = true
    val listOfNews = viewModel.listOfNews
    var new = viewModel.newsDatabase
    val iconFavoriteBool = viewModel.iconFavoriteBool
    val iconBookMarkBool = viewModel.iconBookMarkBool
    val saveDeleteBool = viewModel.saveDeleteBool
    val colorOfIconFavorite = viewModel.colorOfIconFavorite
    val colorOfIconBookMark = viewModel.colorOfIconBookMark
    val error = viewModel.error
    var searchTextField = viewModel.searchTextField
    var counterOfIconFavorite = 0
    var counterOfIconBookMark = 0
    LaunchedEffect(key1 = true) {
        val newsDatabase = NewsDatabase.getInstance(context = context)
        val dao: NewsDao = newsDatabase.getDao()
        viewModel.dao = dao
        viewModel.getAllNews()
    }
    Scaffold(
//        bottomBar = {
//            BottomBar(navController)
//        },
        topBar = {
            HomeScreenTopAppBar(
                value = searchTextField,
                viewModel = viewModel,
                backgroundColor = Color(0xFFCFCFCF),
                iconButtonOnClick = {
                    viewModel.setSearch("")
                },bool=false, backProfileIconButtonOnClick = {})

        }
    ) {
        if (new.value.isNotEmpty())
            LazyColumn() {
                items(new.value) { news ->
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
                            /*val newsRoom = NewsRoom(
                        title = news.title,
                        content = news.content,
                        author = news.author,
                        date = news.date,
                        time = news.time,
                        imageUrl = news.imageUrl,
                        dateTime = System.currentTimeMillis()
                    )
                    viewModel.addNews(newsRoom)*/
                            counterOfIconBookMark++
                            viewModel.setCountIconBookMarkClick(counterOfIconBookMark)
                        },
                        colorOfIconBookMark = colorOfIconBookMark.value,
                        IconBookMarkBool = iconBookMarkBool.value,
                        IconDeleteOnClick = {
                            this@LazyColumn.items(new.value) { new ->
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
        else Text("empty")
    }
}