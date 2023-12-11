package com.ahrorovk.news.presentation.Screens.NewsScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ahrorovk.news.core.formattedDate

@Composable
fun CustomGNewsScreenBox(
    author: String,
    date: String,
    title: String,
    imageUrl: String,
    content: String,
    timeOfAdd: Boolean = false,
    textOfTimeOfAdd: String = "",
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
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
                    modifier = Modifier.padding(start = 3.dp)
                )
            }
            Spacer(Modifier.padding(vertical = 3.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
            )
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
            Spacer(modifier = Modifier.padding(vertical = 6.dp))
            if (timeOfAdd) {
                Spacer(modifier = Modifier.padding(vertical = 6.dp))
                Row(modifier = Modifier.padding(start = 4.dp, end = 4.dp)) {
                    Text(textOfTimeOfAdd, textAlign = TextAlign.Start, fontSize = 14.sp)
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 6.dp))
            Text(
                formattedDate(date),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Row(modifier = Modifier.padding(start = 4.dp, end = 4.dp)) {
                Spacer(modifier = Modifier.padding(vertical = 6.dp))
                Text(content, fontSize = 14.sp)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .clickable { onClick.invoke() },
                    text = author,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Blue,
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }
}

fun Modifier.underline() = this.then(
    Modifier
        .background(Color.Blue)
        .height(2.dp)
)
