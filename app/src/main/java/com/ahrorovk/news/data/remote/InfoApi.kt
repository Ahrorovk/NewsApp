package com.ahrorovk.news.data.remote

import com.ahrorovk.news.domain.Gnews.Gnews

import retrofit2.http.GET
import retrofit2.http.Query

interface InfoApi {
    @GET("search")
    suspend fun getGNews(
        @Query("q")q: String,
        @Query("token")token:String,
        @Query("lang")lang:String,
    ):Gnews
/*  c0f0131bd0127111554aac0b2efccfbf
*/
}