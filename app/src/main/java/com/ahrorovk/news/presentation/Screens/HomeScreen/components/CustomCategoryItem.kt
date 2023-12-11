package com.ahrorovk.news.presentation.Screens.HomeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun CustomCategoryItem(
    title: String,
    isSelected: Boolean,
    onClick: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(
                if (isSelected) MaterialTheme.colors.onPrimary
                else MaterialTheme.colors.primary
            )
            .padding(horizontal = 2.dp)
            .clickable {
                onClick.invoke(title)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(2.dp)
        )
    }
}