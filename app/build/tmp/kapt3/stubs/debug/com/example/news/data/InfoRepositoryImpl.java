package com.example.news.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J)\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/example/news/data/InfoRepositoryImpl;", "Lcom/example/news/data/remote/InfoApi;", "()V", "getCurrency", "Lcom/example/news/domain/currency/currency;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGNews", "Lcom/example/news/domain/Gnews/Gnews;", "search", "", "token", "lang", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNewsAndroid", "Lcom/example/news/domain/NewsInfo/News;", "technology", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class InfoRepositoryImpl implements com.example.news.data.remote.InfoApi {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.news.data.InfoRepositoryImpl INSTANCE = null;
    
    private InfoRepositoryImpl() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getNewsAndroid(@org.jetbrains.annotations.NotNull()
    java.lang.String technology, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.news.domain.NewsInfo.News> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getCurrency(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.news.domain.currency.currency> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getGNews(@org.jetbrains.annotations.NotNull()
    java.lang.String search, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String lang, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.news.domain.Gnews.Gnews> continuation) {
        return null;
    }
}