package com.example.news.domain.NewsDatabase;

import java.lang.System;

@androidx.room.Database(entities = {com.example.news.domain.NewsDatabase.NewsRoom.class}, version = 3, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/news/domain/NewsDatabase/NewsDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getDao", "Lcom/example/news/domain/NewsDatabase/NewsDao;", "Companion", "app_debug"})
public abstract class NewsDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.news.domain.NewsDatabase.NewsDatabase.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.example.news.domain.NewsDatabase.NewsDatabase INSTANCE;
    
    public NewsDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.news.domain.NewsDatabase.NewsDao getDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/example/news/domain/NewsDatabase/NewsDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/news/domain/NewsDatabase/NewsDatabase;", "getINSTANCE", "()Lcom/example/news/domain/NewsDatabase/NewsDatabase;", "setINSTANCE", "(Lcom/example/news/domain/NewsDatabase/NewsDatabase;)V", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.news.domain.NewsDatabase.NewsDatabase getINSTANCE() {
            return null;
        }
        
        public final void setINSTANCE(@org.jetbrains.annotations.Nullable()
        com.example.news.domain.NewsDatabase.NewsDatabase p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.news.domain.NewsDatabase.NewsDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}