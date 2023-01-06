package com.example.news;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/example/news/Constants;", "", "()V", "BASE_URL", "", "BASE_URL_CURRENCY", "BASE_URL_GNEWS", "DRIVER_BASE_URL", "api_key_from_GNews", "bool", "", "getBool", "()Z", "setBool", "(Z)V", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "favoriteScreen", "Landroidx/compose/runtime/MutableState;", "getFavoriteScreen", "()Landroidx/compose/runtime/MutableState;", "setFavoriteScreen", "(Landroidx/compose/runtime/MutableState;)V", "homeScreen", "getHomeScreen", "setHomeScreen", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.news.Constants INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://inshorts.deta.dev/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL_CURRENCY = "https://alif.tj/api/currency/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL_GNEWS = "https://gnews.io/api/v4/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DRIVER_BASE_URL = "https://driverapi.gram.tj/";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String category = "";
    private static boolean bool = false;
    @org.jetbrains.annotations.NotNull()
    private static androidx.compose.runtime.MutableState<java.lang.Boolean> homeScreen;
    @org.jetbrains.annotations.NotNull()
    private static androidx.compose.runtime.MutableState<java.lang.Boolean> favoriteScreen;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String api_key_from_GNews = "c0f0131bd0127111554aac0b2efccfbf";
    
    private Constants() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategory() {
        return null;
    }
    
    public final void setCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getBool() {
        return false;
    }
    
    public final void setBool(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> getHomeScreen() {
        return null;
    }
    
    public final void setHomeScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> getFavoriteScreen() {
        return null;
    }
    
    public final void setFavoriteScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
}