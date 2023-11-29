package com.ahrorovk.news.presentation.Screens.SettingsScreen

sealed class LanguagesEvent {
    object OnBackClick :
        LanguagesEvent()
    data class OnLanguageItemClick(val shortcut: String) : LanguagesEvent()
}