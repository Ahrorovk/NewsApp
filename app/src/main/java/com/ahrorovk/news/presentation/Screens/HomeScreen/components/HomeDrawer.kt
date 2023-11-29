package com.ahrorovk.news.presentation.Screens.HomeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ahrorovk.news.core.Screen


@Composable
fun HomeDrawer(
    currentScreen:String,
    goToSettingsScreen:()->Unit,
    goToNewsScreen:()->Unit,
    openDonationsLink:()->Unit,
    openGithubPage:()->Unit,
    stateLanguage:String
){
    LazyColumn() {
        item {
            Column {
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = if(stateLanguage == "ru") "Волна Новостей" else "News Wave",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                DrawerItem(
                    text = if(stateLanguage == "ru") "Поиск Новостей" else  "Search News",
                    icon = Icons.Default.Search,
                    isActive = currentScreen == Screen.HOME_SCREEN.route
                ) {
                    goToNewsScreen()
                }
                DrawerItem(
                    text = if(stateLanguage == "ru") "Пожертвования" else "Donations",
                    icon = Icons.Default.VolunteerActivism,
                    isActive = false
                ) {
                    openDonationsLink()
                }
                DrawerItem(
                    text = if(stateLanguage == "ru") "Содействовать" else "Contribute",
                    icon = Icons.Default.Favorite,
                    isActive = false
                ) {
                    openGithubPage()
                }
                DrawerItem(
                    text = if(stateLanguage == "ru") "Настройки" else "Settings",
                    icon = Icons.Default.Settings,
                    isActive = currentScreen == Screen.SETTINGS_SCREEN.route
                ) {
                    goToSettingsScreen()
                }
            }
        }
    }
}
@Composable
fun DrawerItem(text:String,icon:ImageVector,isActive:Boolean,onClick:()->Unit){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)
        .clickable {
            onClick()
        }) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(if (isActive) Color.Black.copy(0.4f) else Color.Transparent)
        ) {
            Row( modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    tint = if (isActive) Color.White else Color.Gray
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = text, color = if (isActive) Color.White else Color.Gray)
            }
        }
    }

}