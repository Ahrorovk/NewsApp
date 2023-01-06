package com.example.news.presentation

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.example.news.presentation.Screens.MainViewModel
import com.example.news.presentation.navigation.Navigation
import com.example.news.ui.theme.NewsTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsTheme {
                val viewModel by viewModels<MainViewModel>()
                Navigation(viewModel,applicationContext)

            }
        }

    }
    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        return when (keyCode) {
            KeyEvent.KEYCODE_D -> {
                Toast.makeText(applicationContext,"D", Toast.LENGTH_SHORT).show()
                true
            }
            KeyEvent.KEYCODE_F -> {
                Toast.makeText(applicationContext,"F", Toast.LENGTH_SHORT).show()
                true
            }
            KeyEvent.KEYCODE_J -> {
                Log.e("Click","${KeyEvent.KEYCODE_J}")
                Toast.makeText(applicationContext,"J", Toast.LENGTH_SHORT).show()
                true
            }
            KeyEvent.KEYCODE_K -> {
                Toast.makeText(applicationContext,"K", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onKeyUp(keyCode, event)
        }
    }
}