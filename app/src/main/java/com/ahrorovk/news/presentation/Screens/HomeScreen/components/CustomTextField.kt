package com.ahrorovk.news.presentation.Screens.HomeScreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextField(
    value:String,
    setSearch:(String)->Unit,
    placeholder:String,
    onSearch:()->Unit
) {
    TextField(
        modifier= Modifier
            .fillMaxWidth()
            .padding(end=12.dp, start = 8.dp)
            .height(height = 50.dp),
        value = value,
        placeholder = { Text(text = placeholder, color = Color.Gray, fontSize = 14.sp) },
        onValueChange =  setSearch,
        textStyle = TextStyle.Default.copy(fontSize = 14.sp, fontWeight = FontWeight.Black),
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onBackground,
            disabledTextColor = Color.Transparent,
            backgroundColor = MaterialTheme.colors.primary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colors.onBackground
        ),
        shape = RoundedCornerShape(15.dp),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        trailingIcon = {
            if(value!="") {
                IconButton(onClick = { setSearch("---") }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription =null )
                }
            }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            onSearch()
        }),
    )
}