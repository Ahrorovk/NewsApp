package com.ahrorovk.news.presentation

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.ahrorovk.news.core.DataStoreManager
import com.ahrorovk.news.presentation.Screens.MainViewModel
import com.ahrorovk.news.presentation.ads.loadInterstitial
import com.ahrorovk.news.presentation.navigation.Navigation
import com.ahrorovk.news.ui.theme.NewsTheme
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class MainActivity : ComponentActivity(), CoroutineScope {
    @Inject
    lateinit var dataStoreManager: DataStoreManager

    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main + CoroutineName("Activity Scope") + CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception $throwable in context:$coroutineContext")
        }

    @SuppressLint("StateFlowValueCalledInComposition")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
        dataStoreManager.getLanguageId.onEach {
            val locale = Locale(it)
            Locale.setDefault(locale)
            val resources = this.resources
            val configuration = resources.configuration
            configuration.locale = locale
            resources.updateConfiguration(configuration, resources.displayMetrics)
        }.launchIn(this)

        MobileAds.initialize(this@MainActivity) {}
        loadInterstitial(this)
        setContent {
            val viewModel by viewModels<MainViewModel>()
            NewsTheme {
                Navigation()
            }
        }

    }
}