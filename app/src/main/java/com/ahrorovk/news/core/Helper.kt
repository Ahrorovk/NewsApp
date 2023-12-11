package com.ahrorovk.news.core

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.compose.runtime.MutableState
import com.ahrorovk.news.R
import com.ahrorovk.news.domain.Gnews.GNewsResponseState
import com.ahrorovk.news.presentation.Screens.MainViewModel
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
fun formattedDate(date: String): String {
    val formatter = DateTimeFormatter.ISO_DATE_TIME
    val zonedDateTime = ZonedDateTime.parse(date, formatter.withZone(ZoneId.systemDefault()))
    val localDateTime = LocalDateTime.ofInstant(zonedDateTime.toInstant(), zonedDateTime.zone)
    return localDateTime.format(DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm"))
}

fun getCategories(language: String) = listOf<String>(
    Category(
        "News of the day",
        "Новости дня"
    ).getByLanguage(language),
    Category(
        "Technologies",
        "Технологии"
    ).getByLanguage(language),
    Category(
        "Science",
        "Наука"
    ).getByLanguage(language),
    Category(
        "Biology",
        "Биология"
    ).getByLanguage(language),
    Category(
        "Economic",
        "Экономика"
    ).getByLanguage(language),
    Category(
        "Weather",
        "Погода"
    ).getByLanguage(language),
    Category(
        "Programming",
        "Программирование"
    ).getByLanguage(language)
)

fun getErrorIndicator(viewModel: MainViewModel) =
    if (viewModel.stateGetGNews.value.error == "HTTP 400" && viewModel.searchTextField.isEmpty()) {
        if (viewModel.stateLanguage.value == "ru") "Произошла какая-то ошибка. Введите запрос" else "There's been some kind of mistake. Enter your request"
    } else if (viewModel.stateGetGNews.value.response?.articles?.isEmpty() == true && viewModel.stateGetGNews.value.response?.totalArticles == 0) {
        if (viewModel.stateLanguage.value == "ru") "Произошла какая-то ошибка. Ничего не найдено" else "There's been some kind of mistake. Nothing found"
    } else if (viewModel.stateGetGNews.value.error.trim() == "HTTP 403") {
        if (viewModel.stateLanguage.value == "ru") "На сегодня лимит запросов был исчерпан"
        else "The request limit has been reached for today"
    } else
        viewModel.stateGetGNews.value.error

fun getCurrentLanguage(context: Context): String {
    val configuration = context.resources.configuration
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        configuration.locales.get(0).language
    } else {
        @Suppress("DEPRECATION")
        configuration.locale.language
    }
}

fun getSimpleErrorIndicator(viewModel: MainViewModel) =
    if (viewModel.stateLanguage.value == "ru")
        if (viewModel.isDarkTheme.value)
            R.drawable.homedarkru
        else
            R.drawable.homelightru
    else
        if (viewModel.isDarkTheme.value)
            R.drawable.homedark
        else
            R.drawable.homelight

fun getRetryText(viewModel: MainViewModel) =
    if (viewModel.stateLanguage.value == "ru")
        "Повторить попытку"
    else
        "Try again"