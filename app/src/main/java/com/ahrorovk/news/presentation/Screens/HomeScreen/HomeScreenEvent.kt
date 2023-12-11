package com.ahrorovk.news.presentation.Screens.HomeScreen

import com.ahrorovk.news.domain.model.Language

sealed class HomeScreenEvent{
    data class OnSearchStateChange(val search: String): HomeScreenEvent()
    data class OnLanguageStateChange(val language: Language): HomeScreenEvent()
}
