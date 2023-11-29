package com.ahrorovk.news.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
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
import com.ahrorovk.news.presentation.Screens.SettingsScreen.LanguagesEvent
import com.ahrorovk.news.presentation.ads.showInterstitial
import com.ikcollab.handyhelper.app.presentation.languages.LanguagesScreen
import com.ikcollab.handyhelper.app.presentation.languages.LanguagesViewModel
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

                            else -> ""
                        },
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                    }
                }
            )
        },
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
                        navController.navigate(Screen.HOME_SCREEN.route)
                        coroutineScope.launch {
                            scaffoldState.drawerState.close()
                        }
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
                }
            )
        }
    ) {
        NavHost(navController = navController, startDestination = Screen.HOME_SCREEN.route) {
            composable(route = Screen.HOME_SCREEN.route) {
                val languagesViewModel = hiltViewModel<LanguagesViewModel>()
                val state = languagesViewModel.state.collectAsState()
                LaunchedEffect(key1 = true) {
                    showInterstitial(context) {}
                    viewModel.stateLanguage.value = state.value.selectedLanguage?.shortCut ?: "en"
                }
                val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
                HomeScreen(viewModel)
            }
            composable(Screen.SETTINGS_SCREEN.route) {
                val languagesViewModel = hiltViewModel<LanguagesViewModel>()
                val state = languagesViewModel.state.collectAsState()
                if (state.value.selectedLanguage?.shortCut == "en") {
                    viewModel.stateLanguage.value = "en"
                } else viewModel.stateLanguage.value = "ru"
                LaunchedEffect(key1 = true) {
                    showInterstitial(context) {}
                }


                LanguagesScreen(
                    state = languagesViewModel.state.collectAsState().value,
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
            composable(route = Screen.CURRENCY_SCREEN.route) {
//                CurrencyScreen(navController,viewModel)
            }
        }
    }
}