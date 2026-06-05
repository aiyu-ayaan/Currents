package com.atech.currents.ui.activities.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.atech.currents.ui.screens.demo.DemoScreen
import com.atech.ui.theme.CurrentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val systemDark = isSystemInDarkTheme()
            var isDarkTheme by remember { mutableStateOf(systemDark) }

            CurrentsTheme(darkTheme = isDarkTheme) {
                DemoScreen(
                    isDarkTheme = isDarkTheme,
                    onThemeToggle = { isDarkTheme = it }
                )
            }
        }
    }
}