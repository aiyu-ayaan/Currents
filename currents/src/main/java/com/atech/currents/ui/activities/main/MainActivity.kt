package com.atech.currents.ui.activities.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.atech.core.data.local.pref.PrefManager
import com.atech.currents.navigations.CurrentsAppNavigationEntry
import com.atech.ui.theme.CurrentsTheme
import javax.inject.Inject


val LocalPrefProvider =
    staticCompositionLocalOf<PrefManager> { error("No PrefManger instance provided.") }

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController: NavHostController = rememberNavController()
            CompositionLocalProvider(LocalPrefProvider provides prefManager) {
                CurrentsTheme {
                    CurrentsAppNavigationEntry(
                        modifier = Modifier,
                        navHostController = navHostController,
                    )
                }
            }
        }
    }
}