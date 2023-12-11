package com.ahrorovk.news.core

data class Category(
    val enName: String,
    val ruName: String
) {
    fun getByLanguage(language: String): String {
        return if (language == "ru")
            ruName
        else enName
    }
}
