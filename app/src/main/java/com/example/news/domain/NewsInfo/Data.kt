package com.example.news.domain.NewsInfo

import androidx.room.PrimaryKey

data class Data(
    val author: String,
    val content: String,
    val date: String,
    val imageUrl: String,
    val readMoreUrl: String,
    val time: String,
    val title: String,
    val url: String
)