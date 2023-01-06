package com.example.news;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0007\b\t\n\u000b\f\rB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0007\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/example/news/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "CURRENCY_SCREEN", "FAVORITES_SCREEN", "HOME_SCREEN", "INFO_GRAPH", "INFO_SCREEN", "NAVIGATION_SCREEN", "PROFILE_SCREEN", "Lcom/example/news/Screen$HOME_SCREEN;", "Lcom/example/news/Screen$INFO_SCREEN;", "Lcom/example/news/Screen$PROFILE_SCREEN;", "Lcom/example/news/Screen$FAVORITES_SCREEN;", "Lcom/example/news/Screen$CURRENCY_SCREEN;", "Lcom/example/news/Screen$NAVIGATION_SCREEN;", "Lcom/example/news/Screen$INFO_GRAPH;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/news/Screen$HOME_SCREEN;", "Lcom/example/news/Screen;", "()V", "app_debug"})
    public static final class HOME_SCREEN extends com.example.news.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.news.Screen.HOME_SCREEN INSTANCE = null;
        
        private HOME_SCREEN() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/news/Screen$INFO_SCREEN;", "Lcom/example/news/Screen;", "()V", "app_debug"})
    public static final class INFO_SCREEN extends com.example.news.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.news.Screen.INFO_SCREEN INSTANCE = null;
        
        private INFO_SCREEN() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/news/Screen$PROFILE_SCREEN;", "Lcom/example/news/Screen;", "()V", "app_debug"})
    public static final class PROFILE_SCREEN extends com.example.news.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.news.Screen.PROFILE_SCREEN INSTANCE = null;
        
        private PROFILE_SCREEN() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/news/Screen$FAVORITES_SCREEN;", "Lcom/example/news/Screen;", "()V", "app_debug"})
    public static final class FAVORITES_SCREEN extends com.example.news.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.news.Screen.FAVORITES_SCREEN INSTANCE = null;
        
        private FAVORITES_SCREEN() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/news/Screen$CURRENCY_SCREEN;", "Lcom/example/news/Screen;", "()V", "app_debug"})
    public static final class CURRENCY_SCREEN extends com.example.news.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.news.Screen.CURRENCY_SCREEN INSTANCE = null;
        
        private CURRENCY_SCREEN() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/news/Screen$NAVIGATION_SCREEN;", "Lcom/example/news/Screen;", "()V", "app_debug"})
    public static final class NAVIGATION_SCREEN extends com.example.news.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.news.Screen.NAVIGATION_SCREEN INSTANCE = null;
        
        private NAVIGATION_SCREEN() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/news/Screen$INFO_GRAPH;", "Lcom/example/news/Screen;", "()V", "app_debug"})
    public static final class INFO_GRAPH extends com.example.news.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.news.Screen.INFO_GRAPH INSTANCE = null;
        
        private INFO_GRAPH() {
            super(null);
        }
    }
}