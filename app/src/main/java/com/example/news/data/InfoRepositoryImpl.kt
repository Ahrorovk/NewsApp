package com.example.news.data

import com.example.news.Constants.BASE_URL
import com.example.news.Constants.BASE_URL_CURRENCY
import com.example.news.Constants.BASE_URL_GNEWS
import com.example.news.data.remote.InfoApi
import com.example.news.domain.Gnews.Gnews
import com.example.news.domain.NewsInfo.News
import com.example.news.domain.currency.currency
import com.example.news.domain.currency.currencyResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InfoRepositoryImpl: InfoApi {
    override suspend fun getNewsAndroid(technology:String): News {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build())
            .build()
        val infoApi = retrofit.create(InfoApi::class.java)
        infoApi.getNewsAndroid(technology=technology).let{
            return it
        }
    }
    override suspend fun getCurrency(): currency {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL_CURRENCY)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build())
            .build()
        val authApi = retrofit.create(InfoApi::class.java)
        authApi.getCurrency().let{
            return it
        }
    }

    override suspend fun getGNews(search: String, token: String, lang: String):Gnews {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL_GNEWS)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build())
            .build()
        val authApi = retrofit.create(InfoApi::class.java)
        authApi.getGNews(search,token,lang).let{
            return it
        }
    }
}