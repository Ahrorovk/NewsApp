package com.example.news.presentation.Screens;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010t\u001a\u00020u2\u0006\u0010N\u001a\u00020PJ\u000e\u0010v\u001a\u00020u2\u0006\u0010N\u001a\u00020PJ\u0015\u0010w\u001a\u00020u2\b\u0010x\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010yJ\u000e\u0010z\u001a\u00020u2\u0006\u0010{\u001a\u00020\u000bJ\u0006\u0010|\u001a\u00020uJ\u000e\u0010}\u001a\u00020u2\u0006\u0010~\u001a\u00020\u007fJ*\u0010\u0080\u0001\u001a\u00020u2\u0007\u0010\u0081\u0001\u001a\u00020\u00132\u0007\u0010\u0082\u0001\u001a\u00020\u00132\u0007\u0010\u0083\u0001\u001a\u00020\u00132\u0006\u0010~\u001a\u00020\u007fJE\u0010Q\u001a\u00020u2\u0007\u0010\u0084\u0001\u001a\u00020\u00132\u0007\u0010\u0085\u0001\u001a\u00020\u00132\u0007\u0010\u0086\u0001\u001a\u00020\u00132\u0007\u0010\u0087\u0001\u001a\u00020\u00132\u0007\u0010\u0088\u0001\u001a\u00020\u00132\u0007\u0010\u0089\u0001\u001a\u00020\u00132\u0007\u0010\u008a\u0001\u001a\u00020\u000bJ\u0018\u0010\u008b\u0001\u001a\u00020u2\u0007\u0010\u008c\u0001\u001a\u00020\u00132\u0006\u0010~\u001a\u00020\u007fJ\u0010\u0010\u008d\u0001\u001a\u00020u2\u0007\u0010\u008e\u0001\u001a\u00020\u000bJ\u000f\u0010\u008f\u0001\u001a\u00020u2\u0006\u0010{\u001a\u00020\u000bJ\u000f\u0010\u0090\u0001\u001a\u00020u2\u0006\u0010{\u001a\u00020\u000bJ\u000e\u00105\u001a\u00020u2\u0006\u0010{\u001a\u00020\u0013J\u001f\u0010\u0091\u0001\u001a\u00020u2\u0007\u0010\u0092\u0001\u001a\u00020\u001b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001f\u0010\u0095\u0001\u001a\u00020u2\u0007\u0010\u0092\u0001\u001a\u00020\u001b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\b\u0096\u0001\u0010\u0094\u0001J\u000f\u0010\u0097\u0001\u001a\u00020u2\u0006\u0010{\u001a\u00020\u0013J\u000f\u0010\u0098\u0001\u001a\u00020u2\u0006\u0010{\u001a\u00020\u0013J\u000f\u0010\u0099\u0001\u001a\u00020u2\u0006\u0010{\u001a\u00020\u0013J\u000e\u0010s\u001a\u00020u2\u0006\u0010{\u001a\u00020\u0013R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00138F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R#\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u0086\u000e\u00f8\u0001\u0000\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR#\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u0086\u000e\u00f8\u0001\u0000\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR \u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR \u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u001d\"\u0004\b(\u0010\u001fR+\u0010)\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b,\u0010\u0012\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\u001a\u0010-\u001a\u00020.X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R \u00103\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR+\u00106\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00138F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b9\u0010\u0012\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018R\u000e\u0010:\u001a\u00020;X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001d\"\u0004\bC\u0010\u001fR \u0010D\u001a\b\u0012\u0004\u0012\u00020A0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001d\"\u0004\bF\u0010\u001fR+\u0010H\u001a\u00020G2\u0006\u0010\n\u001a\u00020G8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bM\u0010\u0012\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020P0O\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u001d\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0T0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010\u001dR \u0010V\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u001d\"\u0004\bX\u0010\u001fR\u000e\u0010Y\u001a\u00020ZX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010[\u001a\n ]*\u0004\u0018\u00010\\0\\\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u0010_R \u0010`\u001a\b\u0012\u0004\u0012\u00020A0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u001d\"\u0004\bb\u0010\u001fR+\u0010c\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00138F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bf\u0010\u0012\u001a\u0004\bd\u0010\u0016\"\u0004\be\u0010\u0018R\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00050h\u00a2\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0017\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00070h\u00a2\u0006\b\n\u0000\u001a\u0004\bl\u0010jR\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020\t0h\u00a2\u0006\b\n\u0000\u001a\u0004\bn\u0010jR\u0011\u0010o\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\bp\u0010\u000eR \u0010q\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u001d\"\u0004\bs\u0010\u001f\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u009a\u0001"}, d2 = {"Lcom/example/news/presentation/Screens/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_stateGetCurrency", "Landroidx/compose/runtime/MutableState;", "Lcom/example/news/domain/currency/CurrencyResponseState;", "_stateGetGNews", "Lcom/example/news/domain/Gnews/GNewsResponseState;", "_stateGetNewsAndroid", "Lcom/example/news/domain/NewsInfo/InfoNewsResponseState;", "<set-?>", "", "_stateSearchClick", "get_stateSearchClick", "()I", "set_stateSearchClick", "(I)V", "_stateSearchClick$delegate", "Landroidx/compose/runtime/MutableState;", "", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "category$delegate", "colorOfIconBookMark", "Landroidx/compose/ui/graphics/Color;", "getColorOfIconBookMark", "()Landroidx/compose/runtime/MutableState;", "setColorOfIconBookMark", "(Landroidx/compose/runtime/MutableState;)V", "colorOfIconFavorite", "getColorOfIconFavorite", "setColorOfIconFavorite", "countOfIconBookMarkClick", "getCountOfIconBookMarkClick", "setCountOfIconBookMarkClick", "countOfIconFavoriteClick", "getCountOfIconFavoriteClick", "setCountOfIconFavoriteClick", "counter", "getCounter", "setCounter", "counter$delegate", "dao", "Lcom/example/news/domain/NewsDatabase/NewsDao;", "getDao", "()Lcom/example/news/domain/NewsDatabase/NewsDao;", "setDao", "(Lcom/example/news/domain/NewsDatabase/NewsDao;)V", "email", "getEmail", "setEmail", "error", "getError", "setError", "error$delegate", "getCurrencyUseCase", "Lcom/example/news/domain/currency/GetCurrencyUseCase;", "getGNewsUseCase", "Lcom/example/news/domain/Gnews/GetGNewsUseCase;", "getNewsAndroidUseCase", "Lcom/example/news/domain/NewsInfo/GetNewsAndroidUseCase;", "iconBookMarkBool", "", "getIconBookMarkBool", "setIconBookMarkBool", "iconFavoriteBool", "getIconFavoriteBool", "setIconFavoriteBool", "Lcom/example/news/domain/NewsInfo/News;", "listOfNews", "getListOfNews", "()Lcom/example/news/domain/NewsInfo/News;", "setListOfNews", "(Lcom/example/news/domain/NewsInfo/News;)V", "listOfNews$delegate", "news", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lcom/example/news/domain/NewsDatabase/NewsRoom;", "getNews", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "newsDatabase", "", "getNewsDatabase", "phoneNumber", "getPhoneNumber", "setPhoneNumber", "repository", "Lcom/example/news/data/InfoRepositoryImpl;", "retrofit", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "getRetrofit", "()Lretrofit2/Retrofit;", "saveDeleteBool", "getSaveDeleteBool", "setSaveDeleteBool", "searchTextField", "getSearchTextField", "setSearchTextField", "searchTextField$delegate", "stateGetCurrency", "Landroidx/compose/runtime/State;", "getStateGetCurrency", "()Landroidx/compose/runtime/State;", "stateGetGNews", "getStateGetGNews", "stateGetNewsAndroid", "getStateGetNewsAndroid", "stateSearchClick", "getStateSearchClick", "username", "getUsername", "setUsername", "addNews", "", "deleteNews", "deleteNote", "id", "(Ljava/lang/Integer;)V", "firstNews", "text", "getAllNews", "getCurrency", "context", "Landroid/content/Context;", "getGNews", "search", "token", "lang", "title", "content", "author", "date", "time", "imageUrl", "countOfIconBookMark", "getNewsAndroid", "technology", "searchClick", "b", "setCountIConFavoriteClick", "setCountIconBookMarkClick", "setIconBookMarkColor", "color", "setIconBookMarkColor-8_81llA", "(J)V", "setIconFavoriteColor", "setIconFavoriteColor-8_81llA", "setPhonenumber", "setSearch", "setTopAppBarCategory", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.news.data.InfoRepositoryImpl repository = null;
    private final com.example.news.domain.NewsInfo.GetNewsAndroidUseCase getNewsAndroidUseCase = null;
    private final com.example.news.domain.currency.GetCurrencyUseCase getCurrencyUseCase = null;
    private final com.example.news.domain.Gnews.GetGNewsUseCase getGNewsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.String> username;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.String> email;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.String> phoneNumber;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState category$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState searchTextField$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Integer> countOfIconFavoriteClick;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Integer> countOfIconBookMarkClick;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<androidx.compose.ui.graphics.Color> colorOfIconFavorite;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<androidx.compose.ui.graphics.Color> colorOfIconBookMark;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> iconFavoriteBool;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> iconBookMarkBool;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> saveDeleteBool;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState listOfNews$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState error$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState counter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.snapshots.SnapshotStateList<com.example.news.domain.NewsDatabase.NewsRoom> news = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.util.List<com.example.news.domain.NewsDatabase.NewsRoom>> newsDatabase = null;
    public com.example.news.domain.NewsDatabase.NewsDao dao;
    private final androidx.compose.runtime.MutableState<com.example.news.domain.NewsInfo.InfoNewsResponseState> _stateGetNewsAndroid = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<com.example.news.domain.NewsInfo.InfoNewsResponseState> stateGetNewsAndroid = null;
    private final androidx.compose.runtime.MutableState<com.example.news.domain.currency.CurrencyResponseState> _stateGetCurrency = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<com.example.news.domain.currency.CurrencyResponseState> stateGetCurrency = null;
    private final androidx.compose.runtime.MutableState<com.example.news.domain.Gnews.GNewsResponseState> _stateGetGNews = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<com.example.news.domain.Gnews.GNewsResponseState> stateGetGNews = null;
    private final androidx.compose.runtime.MutableState _stateSearchClick$delegate = null;
    private final int stateSearchClick = 0;
    private final retrofit2.Retrofit retrofit = null;
    
    public MainViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getUsername() {
        return null;
    }
    
    public final void setUsername(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getPhoneNumber() {
        return null;
    }
    
    public final void setPhoneNumber(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategory() {
        return null;
    }
    
    public final void setCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSearchTextField() {
        return null;
    }
    
    public final void setSearchTextField(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Integer> getCountOfIconFavoriteClick() {
        return null;
    }
    
    public final void setCountOfIconFavoriteClick(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Integer> getCountOfIconBookMarkClick() {
        return null;
    }
    
    public final void setCountOfIconBookMarkClick(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<androidx.compose.ui.graphics.Color> getColorOfIconFavorite() {
        return null;
    }
    
    public final void setColorOfIconFavorite(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<androidx.compose.ui.graphics.Color> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<androidx.compose.ui.graphics.Color> getColorOfIconBookMark() {
        return null;
    }
    
    public final void setColorOfIconBookMark(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<androidx.compose.ui.graphics.Color> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> getIconFavoriteBool() {
        return null;
    }
    
    public final void setIconFavoriteBool(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> getIconBookMarkBool() {
        return null;
    }
    
    public final void setIconBookMarkBool(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> getSaveDeleteBool() {
        return null;
    }
    
    public final void setSaveDeleteBool(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.NewsInfo.News getListOfNews() {
        return null;
    }
    
    public final void setListOfNews(@org.jetbrains.annotations.NotNull()
    com.example.news.domain.NewsInfo.News p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getError() {
        return null;
    }
    
    public final void setError(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getCounter() {
        return 0;
    }
    
    public final void setCounter(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.snapshots.SnapshotStateList<com.example.news.domain.NewsDatabase.NewsRoom> getNews() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.util.List<com.example.news.domain.NewsDatabase.NewsRoom>> getNewsDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.news.domain.NewsDatabase.NewsDao getDao() {
        return null;
    }
    
    public final void setDao(@org.jetbrains.annotations.NotNull()
    com.example.news.domain.NewsDatabase.NewsDao p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<com.example.news.domain.NewsInfo.InfoNewsResponseState> getStateGetNewsAndroid() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<com.example.news.domain.currency.CurrencyResponseState> getStateGetCurrency() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<com.example.news.domain.Gnews.GNewsResponseState> getStateGetGNews() {
        return null;
    }
    
    public final void firstNews(int text) {
    }
    
    private final int get_stateSearchClick() {
        return 0;
    }
    
    private final void set_stateSearchClick(int p0) {
    }
    
    public final int getStateSearchClick() {
        return 0;
    }
    
    public final void deleteNote(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id) {
    }
    
    public final void searchClick(int b) {
    }
    
    public final void getAllNews() {
    }
    
    public final void addNews(@org.jetbrains.annotations.NotNull()
    com.example.news.domain.NewsDatabase.NewsRoom news) {
    }
    
    public final void deleteNews(@org.jetbrains.annotations.NotNull()
    com.example.news.domain.NewsDatabase.NewsRoom news) {
    }
    
    public final void getNews(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String time, @org.jetbrains.annotations.NotNull()
    java.lang.String imageUrl, int countOfIconBookMark) {
    }
    
    public final void setUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void setPhonenumber(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void setSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void setCountIConFavoriteClick(int text) {
    }
    
    public final void setCountIconBookMarkClick(int text) {
    }
    
    public final void setTopAppBarCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    public final void getNewsAndroid(@org.jetbrains.annotations.NotNull()
    java.lang.String technology, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void getCurrency(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void getGNews(@org.jetbrains.annotations.NotNull()
    java.lang.String search, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String lang, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
}