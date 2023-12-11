package com.ahrorovk.news.presentation.Screens.HomeScreen.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.BottomNavigation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ahrorovk.news.core.Screen
import com.ahrorovk.news.presentation.Screens.InfoScreen.components.BottomNavDestination
import com.ahrorovk.news.presentation.Screens.InfoScreen.components.BottomNavItem

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun BottomBar(navController: NavController) {

    BottomNavigation(elevation = 10.dp, backgroundColor = Color.LightGray, contentColor = Color.Black) {
        bottomNavDestinations.forEach { navItem ->
            BottomNavItem(navController = navController, item = navItem)
        }
    }
}
val selectedIndex = mutableStateOf(0)
val bottomNavDestinations = listOf(
    BottomNavDestination(
        icon = Icons.Default.Home,
        selected = Color.White,
        unselected = Color.Black,
        label = "Home",
        destinationRoute = Screen.HOME_SCREEN.route,
    ),
    BottomNavDestination(
        icon = Icons.Default.Favorite,
        selected = Color.Red,
        unselected = Color.Black,
        label = "Favorites",
        destinationRoute = Screen.FAVORITES_SCREEN.route,
    )
)