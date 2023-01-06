package com.example.news.domain.NewsDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_table")
data class NewsRoom (
    @PrimaryKey(autoGenerate = true)val id:Int? = null,
    var title:String?,
    var content:String?,
    var imageUrl:String?,
    var author:String,
    var date:String,
    var time:String,
    var dateTime:Long,
    var counterOfIconBookMark:Int
        )