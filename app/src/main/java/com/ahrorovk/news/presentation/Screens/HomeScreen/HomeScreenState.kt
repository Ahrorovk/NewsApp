package com.ahrorovk.news.presentation.Screens.HomeScreen

import com.ahrorovk.news.domain.Gnews.GNewsResponseState
import com.ahrorovk.news.domain.model.Language

data class HomeScreenState(
    val getGNewResponse: GNewsResponseState = GNewsResponseState(),
    val stateLanguage: Language = Language(1, "English", "en"),
    val searchState: String = ""
)
