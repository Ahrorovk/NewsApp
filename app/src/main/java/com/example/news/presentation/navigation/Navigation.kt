package com.example.news.presentation.navigation

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.news.Constants.bool
import com.example.news.Constants.favoriteScreen
import com.example.news.Constants.homeScreen
import com.example.news.Screen
import com.example.news.presentation.Screens.CurrencyScreen.CurrencyScreen
import com.example.news.presentation.Screens.HomeScreen.HomeScreen
import com.example.news.presentation.Screens.HomeScreen.components.BottomBar
import com.example.news.presentation.Screens.InfoScreen.InfoScreen
import com.example.news.presentation.Screens.MainViewModel
import com.example.news.presentation.Screens.ProfileScreen
import com.example.news.presentation.Screens.SavedNewsScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(viewModel: MainViewModel,context: Context) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        bottomBar = {
            if (homeScreen.value || favoriteScreen.value) {
                    BottomBar(navController = navController)
            }
        }
    ) {
        NavHost(navController = navController, startDestination = Screen.HOME_SCREEN.route) {
            composable(route = Screen.HOME_SCREEN.route) {
                HomeScreen(navController = navController,viewModel)
            }
            composable(Screen.INFO_SCREEN.route) { InfoScreen(navController,context,viewModel) }
            composable(Screen.FAVORITES_SCREEN.route) { SavedNewsScreen(navController,context,viewModel) }
            composable(Screen.PROFILE_SCREEN.route) { ProfileScreen(navController,viewModel) }

            composable(route = Screen.CURRENCY_SCREEN.route) {
                CurrencyScreen(navController,viewModel)
            }
        }
    }
}
private fun NavDestination.isCurrentDestinationHasBottomSheet() =
    parent?.route != Screen.CURRENCY_SCREEN.route && parent?.route != Screen.INFO_SCREEN.route

private fun NavDestination.isCurrentDestinationHasTopBar() =
    (parent?.route == Screen.HOME_SCREEN.route ||
            ((parent?.route == Screen.FAVORITES_SCREEN.route && (route?.substring(
                0,
                if ((route?.length ?: 0) >= 30) 30 else 0
            ) ?: "") != Screen.INFO_SCREEN.route) &&
                    (parent?.route == Screen.HOME_SCREEN.route && (route?.substring(
                        0,
                        if ((route?.length ?: 0) >= 26) 26 else 0
                    ) ?: "") != Screen.PROFILE_SCREEN.route)))
