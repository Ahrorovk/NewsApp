package com.ahrorovk.news.presentation.Screens.InfoScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoadingIndicator(isLoading: Boolean, backgroundColor: Color = Color(0x00E5E5E5)) {
    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background).padding(top = 30.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            CircularProgressIndicator(color = Color(0xFFCFCFCF))
        }
    }
}