package com.example.news.presentation.Screens.InfoScreen

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.news.Constants.bool
import com.example.news.Screen
import com.example.news.presentation.Screens.MainViewModel

@Composable
fun InfoGraph(viewModel:MainViewModel,context:Context){
    val navController = rememberNavController()
    bool = false
    NavHost(navController = navController, startDestination = Screen.INFO_SCREEN.route){
        composable(Screen.INFO_SCREEN.route){ InfoScreen(
            navController,
            context,
            viewModel
        )}
    }
}