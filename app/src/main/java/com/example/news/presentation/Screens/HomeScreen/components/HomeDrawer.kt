package com.example.news.presentation.Screens.HomeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.StickyNote2
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun HomeDrawer(
    navController: NavController,
               username:String,
               phoneNumber:String,
               iconButtononClick:()->Unit){
    Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Black),
            contentAlignment = Alignment.CenterStart,
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal=5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .height(44.dp)
                        .width(44.dp),
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint= Color.White
                )
                Column() {
                    Text(
                        text = username,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                    Text(
                        text = phoneNumber,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    IconButton(onClick = { iconButtononClick() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
    LazyColumn() {
        item {
            OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row() {
                        Icon(
                            modifier = Modifier
                                .height(45.dp)
                                .width(65.dp),
                            imageVector = Icons.Outlined.StickyNote2,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(24.dp))
                        Text(text = "Sticker shops")
                    }
                }
            }
            OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row() {
                        Icon(
                            modifier = Modifier
                                .width(65.dp)
                                .height(45.dp),
                            imageVector =Icons.Default.CallMade,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(24.dp))
                        Text(text = "Viber Out")
                    }
                }
            }
            OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row() {
                        Icon(
                            modifier = Modifier
                                .width(65.dp)
                                .height(45.dp),
                            imageVector =Icons.Default.Settings,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(24.dp))
                        Text(text = "Viber Settings")
                    }
                }
            }
            OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row() {
                        Icon(
                            modifier = Modifier
                                .width(65.dp)
                                .height(45.dp),
                            imageVector =Icons.Default.NoteAdd,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(24.dp))
                        Text(text = "My notes")
                    }
                }
            }
            OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row() {
                        Icon(
                            modifier = Modifier
                                .width(65.dp)
                                .height(45.dp),
                            imageVector =Icons.Default.PersonAdd,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(24.dp))
                        Text(text = "Add contact")
                    }
                }
            }
            OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row() {
                        Icon(
                            modifier = Modifier
                                .width(65.dp)
                                .height(45.dp),
                            imageVector =Icons.Default.Share,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(24.dp))
                        Text(text = "invite to Viber")
                    }
                }
            }
            OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row() {
                        Icon(
                            modifier = Modifier
                                .width(65.dp)
                                .height(45.dp),
                            imageVector =Icons.Default.Support,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(24.dp))
                        Text(text = "description and support")
                    }
                }
            }
        }
    }
}