package com.ahrorovk.news.di

import android.content.Context
import com.ahrorovk.news.core.Constants
import com.ahrorovk.news.data.local.DataStoreManager
import com.ahrorovk.news.data.InfoRepositoryImpl
import com.ahrorovk.news.domain.NewsRepository
import com.ahrorovk.news.data.remote.InfoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoreModule {

    @Provides
    @Singleton
    fun provideNewsApi(): InfoApi =
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL_GNEWS)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                )
                    .build()
            )
            .build()
            .create(InfoApi::class.java)

    @Provides
    @Singleton
    fun provideSessionManager(
        @ApplicationContext context: Context
    ) = DataStoreManager(context)

    @Provides
    @Singleton
    fun provideNewsRepository(api: InfoApi): NewsRepository = InfoRepositoryImpl(api)
}