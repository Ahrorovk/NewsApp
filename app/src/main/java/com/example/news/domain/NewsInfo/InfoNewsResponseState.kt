package com.example.news.domain.NewsInfo

import com.example.news.domain.NewsInfo.Data


data class InfoNewsResponseState(
    val isLoading: Boolean = false,
    var response: List<Data>? = null,
    val error: String = ""
)
