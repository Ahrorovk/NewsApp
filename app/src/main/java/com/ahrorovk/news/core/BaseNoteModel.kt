package com.ahrorovk.news.core

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import java.text.SimpleDateFormat
import java.util.*

class BaseNoteModel(private val app: Application): AndroidViewModel(app) {
    companion object {

        fun getDateFormatter(context: Context): SimpleDateFormat {
            val locale = context.resources.configuration.locale
            val pattern = when (locale.language) {
                Locale.CHINESE.language,
                Locale.JAPANESE.language -> "yyyy年 MMM d日 (EEE)"
                else -> "EEE d MMMM yyyy HH:MM:SS"
            }
            return SimpleDateFormat(pattern, locale)
        }
    }
}