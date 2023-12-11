package com.ahrorovk.news.presentation.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@SuppressLint("UnrememberedMutableState")
@Composable
fun SettingsScreen(navController: NavController, viewModel: MainViewModel) {
    Column() {
//        viewModel.getTheme()
        Button(onClick = {
                viewModel.changeLanguage("ru")
        }) {
            Text(text = "RU")
        }
        Button(onClick = {
            viewModel.changeLanguage("en")
        }) {
            Text(text = "EN")
        }
        Button(onClick = {
            viewModel.setTheme(false)
        }) {
            Text(text = "LIGHT")
        }
        Button(onClick = {
            viewModel.setTheme(true)
        }) {
            Text(text = "Dark")
        }

    }
}
@Composable
fun NumberRow(
    text:String,
    placeholder:String,
    value: String,
    onValueChange: (String) -> Unit,
    label:String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(text = text, fontSize = 25.sp, color = Color.Red)
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    label={ Text(text=label) },
                    value = value,
                    onValueChange = onValueChange,
                    placeholder = { Text(placeholder) },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        disabledTextColor = Color.Transparent,
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Black,
                        disabledIndicatorColor = Color.Black
                    )
                )
            }
        }
    }
}