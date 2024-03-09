package com.example.simpleviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.simpleviewmodel.ui.screens.MyApp
import com.example.simpleviewmodel.ui.theme.SimpleViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleViewModelTheme {
                MyApp()
            }
        }
    }
}





