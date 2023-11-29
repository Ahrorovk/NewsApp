package com.ahrorovk.news.presentation.Screens.HomeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahrorovk.news.core.Screen
import com.ahrorovk.news.presentation.Screens.MainViewModel

@Composable
fun HomeScreenTopAppBar(
    backgroundColor: Color,
    value:String,
    viewModel: MainViewModel,
    currentScreen:String,
    onSearch:()->Unit = {},
    scaffoldState: ()->Unit,
    setSearch:(String)->Unit
    ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(backgroundColor)
    ) {
        if  (currentScreen == Screen.HOME_SCREEN.route) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp, end = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = scaffoldState) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
                Row() {

                }
            }
        } else if (currentScreen == Screen.FAVORITES_SCREEN.route) {
            Row (modifier=Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = if (viewModel.stateLanguage.value == "ru")
                        "Сохранённые новости"
                    else
                        "Saved news",
                    fontSize = 25.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }
        } else if (currentScreen == Screen.SETTINGS_SCREEN.route) {
            Row (modifier=Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                IconButton(onClick = scaffoldState) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = if (viewModel.stateLanguage.value == "ru") "Настройки" else "Settings",
                    fontSize = 25.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
