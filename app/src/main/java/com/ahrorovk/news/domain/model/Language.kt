package com.ahrorovk.news.domain.model

data class Language(
    val id: Int,
    val enName: String,
    val ruName: String,
    val shortCut: String,
) {
    fun getByType(language: String): String {
        return when (language) {
            "ru" -> ruName
            else -> enName
        }

    }
}