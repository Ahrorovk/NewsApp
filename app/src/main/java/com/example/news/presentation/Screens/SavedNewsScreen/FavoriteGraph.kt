package com.example.news.presentation.Screens.SavedNewsScreen

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.news.Graph
import com.example.news.Screen
import com.example.news.presentation.Screens.MainViewModel
import com.example.news.presentation.Screens.SavedNewsScreen

@ExperimentalAnimationApi
@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.FavoriteGraph(
    navController: NavHostController,
    viewModel: MainViewModel,
    context: Context
) {
    navigation(
        startDestination = Screen.FAVORITES_SCREEN.route,
        route = Graph.FavoriteGraph.route
    ) {

        composable(route = Screen.FAVORITES_SCREEN.route) {
            SavedNewsScreen(navController,context,viewModel)
        }
    }
}
