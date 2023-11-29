package com.ahrorovk.news.domain.NewsDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_table")
data class NewsRoom(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val name: String,
    val url: String,
    val publishedAt: String,
    val title: String,
    val image: String,
    val description: String,
    var isFav: Boolean,
    var time_of_add: Long
)