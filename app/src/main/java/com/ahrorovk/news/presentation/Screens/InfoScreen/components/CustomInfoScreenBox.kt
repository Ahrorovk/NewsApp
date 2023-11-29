package com.ahrorovk.news.presentation.Screens.InfoScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
@Composable
fun CustomInfoScreenBox(
    author:String,
    time:String,
    date:String,
    title:String,
    imageUrl:String,
    content:String,
    onClick:()->Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFEFEFE))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    title,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 3.dp)
                )
            }
            Spacer(Modifier.padding(vertical=3.dp))
            Divider(modifier= Modifier
                .fillMaxWidth())
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.Crop,
                    painter = rememberAsyncImagePainter(model = imageUrl),
                    contentDescription = null
                )
            }
            Spacer(modifier=Modifier.padding(vertical = 6.dp))
            Spacer(modifier=Modifier.padding(vertical = 6.dp))
            Row(modifier=Modifier.padding(start=4.dp, end = 4.dp)) {
                Spacer(modifier = Modifier.padding(vertical = 6.dp))
                Text(content, fontSize = 14.sp)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                   Text(
                       author,
                       fontSize = 16.sp,
                       fontWeight = FontWeight.SemiBold,
                       color = Color.Black
                   )
                   Column(horizontalAlignment = Alignment.CenterHorizontally) {
                       Text(
                           time,
                           fontSize = 12.sp,
                           fontWeight = FontWeight.Medium,
                           modifier=Modifier.clickable { onClick() }
                       )
                       Spacer(modifier = Modifier.padding(3.dp))
                       Text(
                           date,
                           fontSize = 12.sp,
                           fontWeight = FontWeight.Bold,
                       )
                   }
            }
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }
}