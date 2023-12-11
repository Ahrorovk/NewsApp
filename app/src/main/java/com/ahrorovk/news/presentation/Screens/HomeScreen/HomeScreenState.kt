package com.ahrorovk.news.presentation.Screens.HomeScreen

import com.ahrorovk.news.domain.Gnews.GNewsResponseState
import com.ahrorovk.news.domain.model.Language
import com.ikcollab.handyhelper.app.presentation.languages.getLanguages

data class HomeScreenState(
    val getGNewResponse: GNewsResponseState = GNewsResponseState(),
    val stateLanguage: Language = getLanguages()[0],
    val searchState: String = ""
)
