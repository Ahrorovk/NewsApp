package com.ahrorovk.news.core

sealed class Screen(val route: String) {
    object  HOME_SCREEN: Screen("HOME_SCREEN")
    object INFO_SCREEN : Screen("INFO_SCREEN")
    object PROFILE_SCREEN: Screen("PROFILE_SCREEN")
    object FAVORITES_SCREEN : Screen("FAVORITES_SCREEN")
    object NEWS_SCREEN : Screen("NEWS_SCREEN")
    object SETTINGS_SCREEN: Screen("SETTINGS_SCREEN")
    object INFO_GRAPH : Screen("INFO_GRAPH")
}
