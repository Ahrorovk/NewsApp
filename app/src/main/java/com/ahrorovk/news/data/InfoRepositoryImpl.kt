package com.ahrorovk.news.data

import com.ahrorovk.news.data.remote.InfoApi
import com.ahrorovk.news.domain.Gnews.Gnews
import com.ahrorovk.news.domain.NewsRepository

class InfoRepositoryImpl(
    private val api: InfoApi
) : NewsRepository {
    override suspend fun getGNews(search: String, token: String, lang: String): Gnews =
        api.getGNews(search, token, lang)
}