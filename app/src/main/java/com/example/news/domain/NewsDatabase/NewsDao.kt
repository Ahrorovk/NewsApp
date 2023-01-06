package com.example.news.domain.NewsDatabase

import androidx.room.*

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNews(news: NewsRoom)

    @Query("SELECT *FROM news_table")
    fun getAllNews():List<NewsRoom>

    @Delete
    fun deleteNews(news: NewsRoom)
}