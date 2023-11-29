package com.ahrorovk.news.presentation.Screens

import android.content.Context
import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahrorovk.news.core.Resource
import com.ahrorovk.news.data.PreferenceRepositoryImpl
import com.ahrorovk.news.domain.Gnews.GNewsResponseState
import com.ahrorovk.news.domain.Gnews.GetGNewsUseCase
import com.ahrorovk.news.domain.Gnews.Gnews
import com.ahrorovk.news.presentation.Screens.HomeScreen.HomeScreenEvent
import com.ahrorovk.news.presentation.Screens.HomeScreen.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGNewsUseCase: GetGNewsUseCase
) : ViewModel() {
    val isDarkTheme = mutableStateOf(false)
    private val preferenceRepositoryImpl = PreferenceRepositoryImpl(flow { isDarkTheme.value })

    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.stateIn(
        viewModelScope + Dispatchers.IO,
        SharingStarted.WhileSubscribed(5000),
        HomeScreenState()
    )
    init {
        getTheme()
    }

    val stateLanguage = mutableStateOf("en")
    var searchTextField by mutableStateOf("")
    var error by mutableStateOf("")

    private val _stateGetGNews = mutableStateOf(GNewsResponseState())
    val stateGetGNews: State<GNewsResponseState> = _stateGetGNews

    fun onEvent(event: HomeScreenEvent){
        when(event){
            is HomeScreenEvent.OnSearchStateChange -> {
                _state.update {
                    it.copy(
                        searchState = event.search
                    )
                }
            }

            is HomeScreenEvent.OnLanguageStateChange -> {
                _state.update {
                    it.copy(
                        stateLanguage = event.language
                    )
                }
            }
        }
    }

    fun changeLanguage(text: String) {
        stateLanguage.value = text
    }

    fun clearNews() {
        _stateGetGNews.value = GNewsResponseState()
    }

    private fun getTheme() {
        preferenceRepositoryImpl.darkTheme.onEach {
            isDarkTheme.value = it
        }.launchIn(viewModelScope)
    }

    fun setTheme(value: Boolean) {
        viewModelScope.launch {
            preferenceRepositoryImpl.putDarkThemeValue(value)
        }
    }

    fun setSearch(text: String) {
        searchTextField = text
    }

    fun getGNews(search: String, lang: String, context: Context) {
        getGNewsUseCase.invoke(context = context, search = search.trim(), lang = lang)
            .onEach { result: Resource<Gnews> ->
                when (result) {
                    is Resource.Success -> {
                        try {
                            val res: Gnews? = result.data
                            _stateGetGNews.value = GNewsResponseState(response = res)
                            Log.e("Success", "infoNewsResponse->\n ${res}")
                        } catch (e: Exception) {
                            Log.d("Exception", "${e.message} Exception")
                        }
                    }

                    is Resource.Error -> {
                        _stateGetGNews.value = GNewsResponseState(error = result.message ?: "")
                        Log.e("Error", "infoNewsResponse->\n ${result.message}")

                    }

                    is Resource.Loading -> {
                        _stateGetGNews.value =
                            GNewsResponseState(isLoading = true)
                        Log.e("Load", "-> ${_stateGetGNews.value}")
                    }
                }
            }.launchIn(viewModelScope)
    }
}