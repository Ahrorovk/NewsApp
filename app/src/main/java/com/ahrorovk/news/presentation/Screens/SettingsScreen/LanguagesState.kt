package com.ikcollab.handyhelper.app.presentation.languages

import com.ahrorovk.news.domain.model.Language

data class LanguagesState(
    val languages: List<Language> = getLanguages(),
    val selectedLanguage: Language? = null,
)

fun getLanguages() =
    listOf<Language>(
        Language(1, "English", "Английский", "en"),
        Language(2, "Russian", "Русский", "ru")
    )
