package com.ahrorovk.news.presentation.Screens.InfoScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ErrorIndicator(
    error: String,
    onRetryClick:()->Unit = {},
    backgroundColor: Color = Color(0x00E5E5E5),
    onRetryText:String = "",
    showButton: Boolean = true
) {
    if(showButton) {
        if (error != "") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundColor),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Произошла какая-то ошибка.$error",
                    textAlign = TextAlign.Center,
                    color = Color.Red
                )

                Spacer(modifier = Modifier.height(12.dp))
                Button(colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary), onClick = {
                    onRetryClick()
                }) {
                    Text(text = onRetryText)
                }
            }
        }
    }
    else {
        if (error != "") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundColor),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = error,
                    textAlign = TextAlign.Center,
                    color = Color.Red
                )

//                Spacer(modifier = Modifier.height(12.dp))
//                Button(colors = ButtonDefaults.buttonColors(Color(0xFFCFCFCF)), onClick = {
//                    onRetryClick()
//                }) {
//                    Text(text = onRetryText)
//                }
            }
        }
    }
}