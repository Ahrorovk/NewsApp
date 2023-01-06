package com.example.news.presentation.Screens.InfoScreen.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavDestination(
    val label: String,
    val destinationRoute: String,
    val icon: ImageVector,
    val selected: Color,
    val unselected:Color,
)