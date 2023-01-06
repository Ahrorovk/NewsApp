package com.example.news.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/news/data/remote/InfoApi;", "", "getCurrency", "Lcom/example/news/domain/currency/currency;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGNews", "Lcom/example/news/domain/Gnews/Gnews;", "q", "", "token", "lang", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNewsAndroid", "Lcom/example/news/domain/NewsInfo/News;", "technology", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface InfoApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "news")
    public abstract java.lang.Object getNewsAndroid(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "category")
    java.lang.String technology, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.news.domain.NewsInfo.News> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "index.php")
    public abstract java.lang.Object getCurrency(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.news.domain.currency.currency> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "search")
    public abstract java.lang.Object getGNews(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "q")
    java.lang.String q, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "token")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "lang")
    java.lang.String lang, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.news.domain.Gnews.Gnews> continuation);
}