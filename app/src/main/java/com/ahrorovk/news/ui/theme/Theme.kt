package com.ahrorovk.news.ui.theme

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = primaryDark,
    primaryVariant = topAppBarDark,
    secondary = Teal200,
    background = backGroundDark,
    surface = Color.Black,
    onPrimary = onPrimaryDark,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
)

private val LightColorPalette = lightColors(
    primary = primaryLight,
    primaryVariant = topAppBarLight,
    secondary = Teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = onPrimaryDark,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,

)

@Composable
fun NewsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        Log.e("HELLO","DARK")
        DarkColorPalette
    } else {
        Log.e("HELLO","LIGHT")
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}