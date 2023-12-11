package com.ahrorovk.news.domain.Gnews

data class Gnews(
    val articles: List<Article> = emptyList(),
    val totalArticles: Int = 0
)