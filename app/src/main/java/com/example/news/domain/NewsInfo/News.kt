package com.example.news.domain.NewsInfo

data class News(
    val category: String,
    val `data`: List<Data>,
    val success: Boolean
)