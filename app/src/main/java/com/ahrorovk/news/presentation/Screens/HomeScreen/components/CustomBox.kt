package com.ahrorovk.news.presentation.Screens.HomeScreen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahrorovk.news.core.BaseNoteModel
import com.ahrorovk.news.core.Note
import org.ocpsoft.prettytime.PrettyTime
import java.util.*

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("InvalidColorHexValue")
@Composable
fun CustomBox(
    title:String,
    onClick: () -> Unit,
    onLongClick: () -> Unit
){
    Spacer(modifier= Modifier.padding(vertical=6.dp))
    Box(modifier= Modifier
        .padding(start = 14.dp, end = 14.dp)
        .fillMaxWidth()
        .height(60.dp)
        .combinedClickable(
            onLongClick = onLongClick,
            onClick = onClick)
        .clip(RoundedCornerShape(5.dp))
        .background(Color(0xFFFFFFFF))
        ,
    contentAlignment =Alignment.Center ){
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
                Text(title, fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontSize = 14.sp,
                    text = PrettyTime().format(Date(Note().time)),
                    color = Color.Gray
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    text = BaseNoteModel.getDateFormatter(LocalContext.current)
                        .format(Note().time)
                )
                IconButton(onClick = {onClick()}) {
                    Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = null,Modifier.size(20.dp))
                }
            }
    }
}