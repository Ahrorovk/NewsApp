package com.example.news.presentation.Screens

import android.content.Context
import android.util.Log
import android.view.KeyEvent
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.Constants.BASE_URL
import com.example.news.Resource
import com.example.news.domain.NewsInfo.News
import com.example.news.domain.NewsInfo.GetNewsAndroidUseCase
import com.example.news.domain.NewsInfo.InfoNewsResponseState
import com.example.news.data.InfoRepositoryImpl
import com.example.news.domain.Gnews.GNewsResponseState
import com.example.news.domain.Gnews.GetGNewsUseCase
import com.example.news.domain.Gnews.Gnews
import com.example.news.domain.NewsDatabase.NewsDao
import com.example.news.domain.NewsDatabase.NewsRoom
import com.example.news.domain.currency.CurrencyResponseState
import com.example.news.domain.currency.GetCurrencyUseCase
import com.example.news.domain.currency.currency
import com.example.news.domain.currency.currencyResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel:ViewModel() {

    private val repository= InfoRepositoryImpl
    private val getNewsAndroidUseCase = GetNewsAndroidUseCase(repository)
    private val getCurrencyUseCase = GetCurrencyUseCase(repository)
    private val getGNewsUseCase = GetGNewsUseCase(repository)
    var username = mutableStateOf("")
    var email = mutableStateOf("")
    var phoneNumber = mutableStateOf("")
    var category by mutableStateOf("")
    var searchTextField by mutableStateOf("")
    var countOfIconFavoriteClick = mutableStateOf(0)
    var countOfIconBookMarkClick = mutableStateOf(0)
    var colorOfIconFavorite = mutableStateOf(Color.Black)
    var colorOfIconBookMark = mutableStateOf(Color.Black)
    var iconFavoriteBool = mutableStateOf(false)
    var iconBookMarkBool = mutableStateOf(false)
    var saveDeleteBool = mutableStateOf(false)
    var listOfNews by mutableStateOf<News>(News("", listOf(), false))
    var error by mutableStateOf("")
    var counter by mutableStateOf(0)
    //Room
    val news = mutableStateListOf<NewsRoom>()
    val newsDatabase = mutableStateOf<List<NewsRoom>>(listOf())
    lateinit var dao: NewsDao
    private val _stateGetNewsAndroid = mutableStateOf<InfoNewsResponseState>(InfoNewsResponseState())
    val stateGetNewsAndroid: State<InfoNewsResponseState> = _stateGetNewsAndroid
    private val _stateGetCurrency = mutableStateOf<CurrencyResponseState>(CurrencyResponseState())
    val stateGetCurrency: State<CurrencyResponseState> = _stateGetCurrency
    private val _stateGetGNews = mutableStateOf<GNewsResponseState>(GNewsResponseState())
    val stateGetGNews: State<GNewsResponseState> = _stateGetGNews
    fun firstNews(text:Int){
        counter = text
    }

    private var _stateSearchClick by mutableStateOf(0)
    val stateSearchClick = _stateSearchClick
    fun deleteNote(id: Int?) {
        val newses = news.find {
            it.id == id
        }
        this.news.remove(newses)
    }

    fun searchClick(b:Int){
        _stateSearchClick = b
    }
    fun getAllNews() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                newsDatabase.value = dao.getAllNews()
            }
        }
    }

    fun addNews(news: NewsRoom) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dao.addNews(news)
                getAllNews()
            }
        }
    }
    fun deleteNews(news: NewsRoom) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dao.deleteNews(news)
                getAllNews()
            }
        }
    }
    fun getNews(
        title:String,
        content:String,
        author:String,
        date:String,
        time:String,
        imageUrl:String,
        countOfIconBookMark:Int
        ){
        val newsRoom = NewsRoom(
            title = title,
            content = content,
            author = author,
            date = date,
            time = time,
            imageUrl = imageUrl,
            dateTime = System.currentTimeMillis(),
            counterOfIconBookMark = countOfIconBookMark%2
        )
        addNews(newsRoom)
    }
    fun setUsername(text: String) {
        if (text.isNotEmpty())
            username.value = text
    }

    fun setEmail(text: String) {
        if (text.isNotEmpty())
            email.value = text

    }

    fun setPhonenumber(text: String) {
        if (text.isNotEmpty())
            phoneNumber.value = text
    }

    fun setSearch(text: String) {
        searchTextField = text
    }

    fun setIconFavoriteColor(color: Color) {
        colorOfIconFavorite.value = color
    }

    fun setCountIConFavoriteClick(text: Int) {
        countOfIconFavoriteClick.value = (text % 2)
        if (countOfIconFavoriteClick.value == 0) {
            saveDeleteBool.value = false
            iconFavoriteBool.value = false
            setIconFavoriteColor(Color.Black)
        } else if (countOfIconFavoriteClick.value == 1) {
            iconFavoriteBool.value = true
            setIconFavoriteColor(Color.Red)
        }
        Log.e("CountClick -> ", countOfIconFavoriteClick.value.toString())
    }

    fun setIconBookMarkColor(color: Color) {
        colorOfIconBookMark.value = color
    }

    fun setCountIconBookMarkClick(text: Int) {
        countOfIconBookMarkClick.value = (text % 2)
        if (countOfIconBookMarkClick.value == 0) {

            iconBookMarkBool.value = false
            setIconBookMarkColor(Color.Black)
        } else if (countOfIconBookMarkClick.value == 1) {
            saveDeleteBool.value = true
            iconBookMarkBool.value = true
            setIconBookMarkColor(Color.Black)
        }
        Log.e("CountClick_1 -> ", countOfIconBookMarkClick.value.toString())
    }

    fun setTopAppBarCategory(text: String) {
        category = text
    }

    //Retrofit
    val retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder().addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getNewsAndroid(technology: String,context:Context) {
        getNewsAndroidUseCase.invoke(technology, context = context).onEach { result: Resource<News> ->
            when (result) {
                is Resource.Success -> {
                    try {
                        val res = result.data
                        _stateGetNewsAndroid.value = InfoNewsResponseState(response = res?.data)
                        Log.e("Success", "infoNewsResponse->\n ${res}")
                    } catch (e: Exception) {
                        Log.d("Exception", "${e.message} Exception")
                    }
                }
                is Resource.Error -> {
                    Log.e("Error", "infoNewsResponse->\n ${result.message}")

                }
                is Resource.Loading -> {
                    _stateGetNewsAndroid.value=
                        InfoNewsResponseState(isLoading = true)
                    Log.e("Load","-> ${_stateGetNewsAndroid.value}")
                }
            }
        }.launchIn(viewModelScope)
    }
    fun getCurrency(context:Context) {
        getCurrencyUseCase.invoke( context = context).onEach { result: Resource<currency> ->
            when (result) {
                is Resource.Success -> {
                    try {
                        val res:currency? = result.data
                        _stateGetCurrency.value = CurrencyResponseState(response = res)
                        Log.e("Success", "infoNewsResponse->\n ${res}")
                    } catch (e: Exception) {
                        Log.d("Exception", "${e.message} Exception")
                    }
                }
                is Resource.Error -> {
                    _stateGetCurrency.value = CurrencyResponseState(error = result.message?:"")
                    Log.e("Error", "infoNewsResponse->\n ${result.message}")

                }
                is Resource.Loading -> {
                    _stateGetCurrency.value=
                        CurrencyResponseState(isLoading = true)
                    Log.e("Load","-> ${_stateGetNewsAndroid.value}")
                }
            }
        }.launchIn(viewModelScope)
    }


    fun getGNews(search:String,token:String , lang:String ,context:Context) {
        getGNewsUseCase.invoke( context = context, search = search, token = token, lang = lang).onEach { result: Resource<Gnews> ->
            when (result) {
                is Resource.Success -> {
                    try {
                        val res:Gnews? = result.data
                        _stateGetGNews.value = GNewsResponseState(response = res)
                        Log.e("Success", "infoNewsResponse->\n ${res}")
                    } catch (e: Exception) {
                        Log.d("Exception", "${e.message} Exception")
                    }
                }
                is Resource.Error -> {
                    _stateGetGNews.value = GNewsResponseState(error = result.message?:"")
                    Log.e("Error", "infoNewsResponse->\n ${result.message}")

                }
                is Resource.Loading -> {
                    _stateGetGNews.value=
                        GNewsResponseState(isLoading = true)
                    Log.e("Load","-> ${_stateGetNewsAndroid.value}")
                }
            }
        }.launchIn(viewModelScope)
    }
}