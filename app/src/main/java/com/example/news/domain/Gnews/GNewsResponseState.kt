package com.example.news.domain.Gnews


data class GNewsResponseState (
    val isLoading: Boolean = false,
    var response: Gnews? = null,
    val error: String = ""
)
