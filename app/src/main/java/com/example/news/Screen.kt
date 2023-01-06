package com.example.news

sealed class Screen(val route: String) {
    object  HOME_SCREEN:Screen("HOME_SCREEN")
    object INFO_SCREEN :Screen("INFO_SCREEN")
    object PROFILE_SCREEN:Screen("PROFILE_SCREEN")
    object FAVORITES_SCREEN :Screen("FAVORITES_SCREEN")
    object CURRENCY_SCREEN :Screen("CURRENCY_SCREEN")
    object NAVIGATION_SCREEN: Screen("NAVIGATION_SCREEN")
    object INFO_GRAPH :Screen("INFO_GRAPH")
}
