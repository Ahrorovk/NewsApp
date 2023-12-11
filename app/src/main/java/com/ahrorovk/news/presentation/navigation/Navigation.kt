package com.ahrorovk.news.presentation.navigation

import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ahrorovk.news.core.Screen
import com.ahrorovk.news.presentation.Screens.HomeScreen.HomeScreen
import com.ahrorovk.news.presentation.Screens.HomeScreen.HomeScreenViewModel
import com.ahrorovk.news.presentation.Screens.HomeScreen.components.HomeDrawer
import com.ahrorovk.news.presentation.Screens.MainViewModel
import com.ahrorovk.news.presentation.Screens.NewsScreen.NewsScreen
import com.ahrorovk.news.presentation.Screens.SettingsScreen.LanguagesEvent
import com.ahrorovk.news.presentation.ads.showInterstitial
import com.ahrorovk.news.presentation.ads.showRewardedAd
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ikcollab.handyhelper.app.presentation.languages.LanguagesScreen
import com.ikcollab.handyhelper.app.presentation.languages.LanguagesViewModel
import com.iogram.traffic.presentation.components.DefaultSnackbar
import kotlinx.coroutines.launch
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(viewModel: MainViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(viewModel.totalStateOfCoins.value) {
        if (viewModel.totalStateOfCoins.value == 0L) {
            scaffoldState.snackbarHostState.showSnackbar(
                "",
                duration = SnackbarDuration.Indefinite,
                actionLabel = if (viewModel.stateLanguage.value == "ru") "Отмена" else "Cancel"
            )
        }
    }
    val currentScreen = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(backgroundColor = MaterialTheme.colors.primaryVariant,
                title = {
                    Text(
                        text = when (currentScreen) {
                            Screen.HOME_SCREEN.route -> if (viewModel.stateLanguage.value == "ru") "Волна Новостей" else "News Wave"
                            Screen.SETTINGS_SCREEN.route -> {
                                if (viewModel.stateLanguage.value == "ru") "Настройки" else "Settings"
                            }

                            Screen.NEWS_SCREEN.route -> viewModel.currentSourceNameState.value
                            else -> ""
                        },
                    )
                },
                navigationIcon = {
                    if (currentScreen == Screen.NEWS_SCREEN.route) {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBackIosNew,
                                contentDescription = null
                            )
                        }
                    } else {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                        }
                    }
                }
            )
        }, snackbarHost = {
            if (viewModel.totalStateOfCoins.value == 0L) {
                DefaultSnackbar(
                    scaffoldState.snackbarHostState, modifier = Modifier.offset(y = (-50).dp),
                    message = if (viewModel.stateLanguage.value == "ru") "Посмотри ролик и получи +5 монет" else "Watch the video and get +5 coins",
                    onDismiss = {
                        scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                    },
                    onClick = {
                        showRewardedAd(context, {
                            viewModel.addCoins(viewModel.totalStateOfCoins.value.toInt() + it)
                        }) {
                            Toast.makeText(
                                context,
                                if (viewModel.stateLanguage.value == "ru") "Реклама ещё не готова. Повторите попытку позже" else "The advertisement is not ready yet. Please try again later",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                )
            }
        },
        drawerGesturesEnabled = currentScreen != Screen.NEWS_SCREEN.route,
        drawerContent = {
            HomeDrawer(
                currentScreen,
                goToSettingsScreen = {
                    if (currentScreen != Screen.SETTINGS_SCREEN.route) {
                        navController.navigate(Screen.SETTINGS_SCREEN.route)
                        coroutineScope.launch {
                            scaffoldState.drawerState.close()
                        }
                    }
                },
                stateLanguage = viewModel.stateLanguage.value,
                goToNewsScreen = {
                    if (currentScreen != Screen.HOME_SCREEN.route) {
                        navController.popBackStack()
                        coroutineScope.launch {
                            scaffoldState.drawerState.close()
                        }
                    }
                },
                shareAppLink = {
                    val share = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.ahrorovk.news")
                    }
                    context.startActivity(share)
                },
                watchAds = {
                    showRewardedAd(context, {
                        viewModel.addCoins(viewModel.totalStateOfCoins.value.toInt() + it)
                    }) {
                        Toast.makeText(
                            context,
                            if (viewModel.stateLanguage.value == "ru") "Реклама ещё не готова. Повторите попытку позже" else "The advertisement is not ready yet. Please try again later",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                },
                openDonationsLink = {
                    uriHandler.openUri("https://www.buymeacoffee.com/akhrorovk5P")
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                },
                openGithubPage = {
                    uriHandler.openUri("https://github.com/Ahrorovk/NewsApp")
                },
                coins = viewModel.totalStateOfCoins.value
            )
        }
    ) { it ->
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = Screen.HOME_SCREEN.route
        ) {
            composable(route = Screen.HOME_SCREEN.route) {
                LaunchedEffect(key1 = true) {
                    showInterstitial(context) {}
                }
                val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
                HomeScreen(viewModel) {
                    navController.navigate(Screen.NEWS_SCREEN.route)
                }
            }
            composable(Screen.SETTINGS_SCREEN.route) {
                val languagesViewModel = hiltViewModel<LanguagesViewModel>()
                val state = languagesViewModel.state.collectAsState()
                LaunchedEffect(key1 = true) {
                    showInterstitial(context) {}
                }

                LanguagesScreen(
                    state = state.value,
                    onEvent = { event ->
                        when (event) {
                            is LanguagesEvent.OnBackClick -> {
                                navController.popBackStack()
                            }

                            is LanguagesEvent.OnLanguageItemClick -> {
                                val locale = Locale(event.shortcut)
                                Locale.setDefault(locale)
                                val resources = context.resources
                                val configuration = resources.configuration
                                configuration.locale = locale
                                resources.updateConfiguration(
                                    configuration,
                                    resources.displayMetrics
                                )
                                languagesViewModel.onEvent(event)
                            }

                            else -> {
                                languagesViewModel.onEvent(event)
                            }
                        }
                    })
            }
            composable(route = Screen.NEWS_SCREEN.route) {
                NewsScreen(viewModel = viewModel)
            }
        }
    }
}