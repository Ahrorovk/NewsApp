package com.ahrorovk.news.presentation.Screens

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahrorovk.news.core.Resource
import com.ahrorovk.news.data.PreferenceRepositoryImpl
import com.ahrorovk.news.data.local.DataStoreManager
import com.ahrorovk.news.domain.Gnews.GNewsResponseState
import com.ahrorovk.news.domain.Gnews.GetGNewsUseCase
import com.ahrorovk.news.domain.Gnews.Gnews
import com.ahrorovk.news.presentation.Screens.HomeScreen.HomeScreenEvent
import com.ahrorovk.news.presentation.Screens.HomeScreen.HomeScreenState
import com.ikcollab.handyhelper.app.presentation.languages.getLanguages
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGNewsUseCase: GetGNewsUseCase,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {
    val isDarkTheme = mutableStateOf(false)
    private val preferenceRepositoryImpl = PreferenceRepositoryImpl(flow { isDarkTheme.value })

    private val _currentUrlState = mutableStateOf("")
    val currentUrlState: State<String> = _currentUrlState

    private val _currentSourceNameState = mutableStateOf("")
    val currentSourceNameState: State<String> = _currentSourceNameState


    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.stateIn(
        viewModelScope + Dispatchers.IO,
        SharingStarted.WhileSubscribed(5000),
        HomeScreenState()
    )

    private val _totalStateOfCoins = mutableStateOf(0L)
    val totalStateOfCoins: State<Long> = _totalStateOfCoins
    val stateLanguage = mutableStateOf("en")

    init {
        dataStoreManager.getCoins.onEach { coins ->
            _totalStateOfCoins.value = coins
        }.launchIn(viewModelScope)

        dataStoreManager.getLanguageId.onEach { id ->
            stateLanguage.value = getLanguages().filter { it.shortCut == id }[0].shortCut
        }.launchIn(viewModelScope)

        getTheme()
    }


    var searchTextField by mutableStateOf("")
    var stateOfCategory = mutableStateOf("")
    var error by mutableStateOf("")

    private val _stateGetGNews = mutableStateOf(GNewsResponseState())
    val stateGetGNews: State<GNewsResponseState> = _stateGetGNews

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
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


    fun addCoins(coins: Int) {
        viewModelScope.launch {
            dataStoreManager.updateCoins(coins.toLong())
        }
    }

    fun changeCurrentUrlState(state: String) {
        _currentUrlState.value = state
    }

    fun changeCurrentSourceNameState(state: String) {
        _currentSourceNameState.value = state
    }

    fun changeLanguage(text: String) {
        stateLanguage.value = text
    }

    fun changeStateOfCategory(state: String) {
        stateOfCategory.value = state
    }

    fun clearNews() {
        _stateGetGNews.value = GNewsResponseState()
    }

    private fun getTheme() {
        dataStoreManager.getDarkThemeState.onEach {
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

    fun getGNews(search: String, lang: String, context: Context, onSucess: () -> Unit = {}) {
        if (_totalStateOfCoins.value > 0)
            getGNewsUseCase.invoke(context = context, search = search.trim(), lang = lang)
                .onEach { result: Resource<Gnews> ->
                    when (result) {
                        is Resource.Success -> {
                            try {
                                val res: Gnews? = result.data
                                dataStoreManager.updateCoins(_totalStateOfCoins.value - 1)
                                _stateGetGNews.value = GNewsResponseState(response = res)
                                onSucess.invoke()
                                Log.e("Success", "infoNewsResponse->\n $res")
                            } catch (e: Exception) {
                                Log.d("Exception", "${e.message} Exception")
                            }
                        }

                        is Resource.Error -> {
                            _stateGetGNews.value = GNewsResponseState(
                                error = result.message ?: ""
                            )
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