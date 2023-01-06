package com.example.news.domain.currency

//import com.example.news.domain.NewsInfo.Data

class CurrencyResponseState (
    val isLoading: Boolean = false,
    var response: currency? = null,
    val error: String = ""
)
