package com.ahrorovk.news.data.remote

import kotlinx.coroutines.flow.Flow

interface Preference {

    suspend fun putDarkThemeValue(value: Boolean)

    var darkTheme: Flow<Boolean>

}