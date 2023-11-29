package com.ahrorovk.news.data

import com.ahrorovk.news.data.remote.Preference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PreferenceRepositoryImpl(override var darkTheme:Flow<Boolean>):Preference {
    override suspend fun putDarkThemeValue(value: Boolean) {
        darkTheme = flow { value }
    }

}