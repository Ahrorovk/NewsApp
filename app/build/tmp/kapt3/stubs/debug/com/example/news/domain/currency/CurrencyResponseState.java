package com.example.news.domain.currency;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/news/domain/currency/CurrencyResponseState;", "", "isLoading", "", "response", "Lcom/example/news/domain/currency/currency;", "error", "", "(ZLcom/example/news/domain/currency/currency;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "()Z", "getResponse", "()Lcom/example/news/domain/currency/currency;", "setResponse", "(Lcom/example/news/domain/currency/currency;)V", "app_debug"})
public final class CurrencyResponseState {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable()
    private com.example.news.domain.currency.currency response;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String error = null;
    
    public CurrencyResponseState() {
        super();
    }
    
    public CurrencyResponseState(boolean isLoading, @org.jetbrains.annotations.Nullable()
    com.example.news.domain.currency.currency response, @org.jetbrains.annotations.NotNull()
    java.lang.String error) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.news.domain.currency.currency getResponse() {
        return null;
    }
    
    public final void setResponse(@org.jetbrains.annotations.Nullable()
    com.example.news.domain.currency.currency p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getError() {
        return null;
    }
}