package com.example.news.domain.NewsDatabase;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'\u00a8\u0006\t"}, d2 = {"Lcom/example/news/domain/NewsDatabase/NewsDao;", "", "addNews", "", "news", "Lcom/example/news/domain/NewsDatabase/NewsRoom;", "deleteNews", "getAllNews", "", "app_debug"})
public abstract interface NewsDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addNews(@org.jetbrains.annotations.NotNull()
    com.example.news.domain.NewsDatabase.NewsRoom news);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT *FROM news_table")
    public abstract java.util.List<com.example.news.domain.NewsDatabase.NewsRoom> getAllNews();
    
    @androidx.room.Delete()
    public abstract void deleteNews(@org.jetbrains.annotations.NotNull()
    com.example.news.domain.NewsDatabase.NewsRoom news);
}