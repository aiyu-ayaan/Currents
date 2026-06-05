package com.atech.currents.ui.activities.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.atech.currents.navigations.CurrentsAppNavigationEntry
import com.atech.ui.theme.CurrentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        val navHostController : NavHostController = rememberNavController()
            CurrentsTheme {
                CurrentsAppNavigationEntry(
                    modifier = Modifier,
                    navHostController = navHostController,
                )
            }
        }
    }
}