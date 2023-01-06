package com.example.news.domain.currency;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0007H\u00c6\u0003J\t\u0010*\u001a\u00020\tH\u00c6\u0003J\t\u0010+\u001a\u00020\u000bH\u00c6\u0003J\t\u0010,\u001a\u00020\rH\u00c6\u0003J\t\u0010-\u001a\u00020\u000fH\u00c6\u0003J\t\u0010.\u001a\u00020\u0011H\u00c6\u0003J\t\u0010/\u001a\u00020\u0013H\u00c6\u0003Jc\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u00c6\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u000205H\u00d6\u0001J\t\u00106\u001a\u000207H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&\u00a8\u00068"}, d2 = {"Lcom/example/news/domain/currency/currency;", "", "AED", "Lcom/example/news/domain/currency/AED;", "CNY", "Lcom/example/news/domain/currency/CNY;", "EUR", "Lcom/example/news/domain/currency/EUR;", "GBP", "Lcom/example/news/domain/currency/GBP;", "KZT", "Lcom/example/news/domain/currency/KZT;", "RUB", "Lcom/example/news/domain/currency/RUB;", "TRY", "Lcom/example/news/domain/currency/TRY;", "USD", "Lcom/example/news/domain/currency/USD;", "UZS", "Lcom/example/news/domain/currency/UZS;", "(Lcom/example/news/domain/currency/AED;Lcom/example/news/domain/currency/CNY;Lcom/example/news/domain/currency/EUR;Lcom/example/news/domain/currency/GBP;Lcom/example/news/domain/currency/KZT;Lcom/example/news/domain/currency/RUB;Lcom/example/news/domain/currency/TRY;Lcom/example/news/domain/currency/USD;Lcom/example/news/domain/currency/UZS;)V", "getAED", "()Lcom/example/news/domain/currency/AED;", "getCNY", "()Lcom/example/news/domain/currency/CNY;", "getEUR", "()Lcom/example/news/domain/currency/EUR;", "getGBP", "()Lcom/example/news/domain/currency/GBP;", "getKZT", "()Lcom/example/news/domain/currency/KZT;", "getRUB", "()Lcom/example/news/domain/currency/RUB;", "getTRY", "()Lcom/example/news/domain/currency/TRY;", "getUSD", "()Lcom/example/news/domain/currency/USD;", "getUZS", "()Lcom/example/news/domain/currency/UZS;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class currency {
    @org.jetbrains.annotations.NotNull()
    private final com.example.news.domain.currency.AED AED = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.news.domain.currency.CNY CNY = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.news.domain.currency.EUR EUR = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.news.domain.currency.GBP GBP = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.news.domain.currency.KZT KZT = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.news.domain.currency.RUB RUB = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.news.domain.currency.TRY TRY = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.news.domain.currency.USD USD = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.news.domain.currency.UZS UZS = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.currency copy(@org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.AED AED, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.CNY CNY, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.EUR EUR, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.GBP GBP, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.KZT KZT, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.RUB RUB, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.TRY TRY, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.USD USD, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.UZS UZS) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public currency(@org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.AED AED, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.CNY CNY, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.EUR EUR, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.GBP GBP, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.KZT KZT, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.RUB RUB, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.TRY TRY, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.USD USD, @org.jetbrains.annotations.NotNull()
    com.example.news.domain.currency.UZS UZS) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.AED component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.AED getAED() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.CNY component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.CNY getCNY() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.EUR component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.EUR getEUR() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.GBP component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.GBP getGBP() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.KZT component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.KZT getKZT() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.RUB component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.RUB getRUB() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.TRY component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.TRY getTRY() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.USD component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.USD getUSD() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.UZS component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.currency.UZS getUZS() {
        return null;
    }
}