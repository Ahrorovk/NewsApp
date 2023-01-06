package com.example.news.data.remote

import android.icu.text.StringSearch
import com.example.news.domain.Gnews.Gnews
import com.example.news.domain.NewsInfo.News
import com.example.news.domain.currency.currency
import com.example.news.domain.currency.currencyResponse

import retrofit2.http.GET
import retrofit2.http.Query

interface InfoApi {
    @GET("news")
    suspend fun getNewsAndroid(@Query("category") technology:String): News
    @GET("index.php")
    suspend fun getCurrency(): currency
    @GET("search")
    suspend fun getGNews(
        @Query("q")q: String,
        @Query("token")token:String,
        @Query("lang")lang:String,
    ):Gnews
/*  c0f0131bd0127111554aac0b2efccfbf
    @GET("news?category=ios")
    fun getNewsIos(): Call<News>

    @GET("news?category=apple")
    fun getNewsApple(): Call<News>

    @GET("news?category=samsung")
    fun getNewsSamsung(): Call<News>

    @GET("news?category=technology")
    fun getNewsTechnology(): Call<News>
    @GET("news?category=amazon")
    fun getNewsAmazon(): Call<News>
    @GET("news?category=science")
    fun getNewsScience(): Call<News>
    @GET("news?category=cars")
    fun getNewsCars(): Call<News>
    @GET("news?category=honda")
    fun getNewsHonda(): Call<News>
    @GET("news?category=bmw")
    fun getNewsBmw(): Call<News>
    @GET("news?category=mercedes")
    fun getNewsMercedes(): Call<News>
    @GET("news?category=usa")
    fun getNewsUsa(): Call<News>
    @GET("news?category=europe")
    fun getNewsEurope(): Call<News>*/


}