package com.example.news.presentation.Screens.InfoScreen.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.news.Screen


@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun RowScope.BottomNavItem(
    navController: NavController,
    item: BottomNavDestination
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigationItem(
        selected = currentDestination?.hierarchy?.any {
            when (item.destinationRoute) {
                Screen.HOME_SCREEN.route -> {
                    it.route == Screen.HOME_SCREEN.route
                }
                Screen.FAVORITES_SCREEN.route -> {
                    it.route == Screen.FAVORITES_SCREEN.route
                }
                else -> {
                    it.route == Screen.FAVORITES_SCREEN.route }
            }
        } == true,
        onClick = {
            navigateToScreen(item.destinationRoute, navController)
        },
        icon = {
            Alignment.Center
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = item.icon,
                contentDescription = "BottomNavIcon",
            )
        },
        label = {
            Text(
                text = item.label,
                fontSize = 10.sp
            )
        },
        selectedContentColor = item.selected,
        unselectedContentColor = item.unselected,
    )
}

private fun navigateToScreen(route: String, navController: NavController) {
    navController.navigate(route = route) {
        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}