package com.ahrorovk.news.domain

import com.ahrorovk.news.domain.Gnews.Gnews

interface NewsRepository {
    suspend fun getGNews(search: String, token: String, lang: String): Gnews
}