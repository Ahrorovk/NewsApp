package com.example.news.presentation.Screens.HomeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.presentation.Screens.MainViewModel

@Composable
fun HomeScreenTopAppBar(
    backgroundColor:Color,
    value:String,
    iconButtonOnClick:()->Unit,
    viewModel: MainViewModel,
    bool:Boolean,
    backProfileIconButtonOnClick:()->Unit,
    onSearch:()->Unit = {}
    )
{
    val context = LocalContext.current
    Box(modifier= Modifier
        .fillMaxWidth()
        .height(55.dp)
        .background(backgroundColor)) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, end = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if(!bool) {
                Text(
                    "TOPICS",
                    fontSize = 30.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
                Row() {
                    TextField(
                        modifier = Modifier
                            .width(200.dp)
                            .height(50.dp),
                        value = value,
                        keyboardOptions = KeyboardOptions( imeAction =ImeAction.Search),
                        keyboardActions = KeyboardActions( onSearch = {
                            onSearch()
                        })
                        ,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        },
                        onValueChange = {
                            viewModel.setSearch(it)
                        },
                        placeholder = {
                            Text("Search more categories", fontSize = 12.sp)
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Black,
                            disabledTextColor = Color.Transparent,
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Black,
                            unfocusedIndicatorColor = Color.Black,
                            disabledIndicatorColor = Color.Black
                        )
                    )
                    if (value != "") {
                        IconButton(onClick = {
                            iconButtonOnClick()
                        }) {
                            Icon(
                                modifier = Modifier.size(14.dp),
                                imageVector = Icons.Outlined.Cancel,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
            else {
                IconButton(onClick = { backProfileIconButtonOnClick() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
                Text(modifier=Modifier.fillMaxWidth(), textAlign = TextAlign.Center,text="Profile",fontSize = 30.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold)
            }
        }
    }

}
