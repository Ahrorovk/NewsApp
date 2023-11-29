package com.ahrorovk.news.core

import android.annotation.SuppressLint
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
fun formattedDate(date :String ): String {
    val formatter = DateTimeFormatter.ISO_DATE_TIME
    val zonedDateTime = ZonedDateTime.parse(date, formatter.withZone(ZoneId.systemDefault()))
    val localDateTime = LocalDateTime.ofInstant(zonedDateTime.toInstant(), zonedDateTime.zone)
    return localDateTime.format(DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm"))
}