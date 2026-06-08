package com.atech.currents.navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.atech.core.data.local.pref.PrefKey
import com.atech.currents.ui.activities.main.LocalPrefProvider
import com.atech.currents.ui.screens.base.CurrentsNavigationBaseScreen
import com.atech.currents.ui.screens.login.LoginScreen
import kotlinx.serialization.Serializable

sealed interface CurrentsAppNavigationRoutes : NavKey {
    @Serializable
    object LogIn : CurrentsAppNavigationRoutes, NavKey

    // routes for nested navigation
    @Serializable
    object Currents : CurrentsAppNavigationRoutes, NavKey
}


@Composable
fun CurrentsAppNavigationEntry(
    modifier: Modifier = Modifier,
    startDestination: NavKey = CurrentsAppNavigationRoutes.LogIn
) {
    val pref = LocalPrefProvider.current
    val backstack = rememberNavBackStack(startDestination)
    NavDisplay(
        modifier = modifier,
        backStack = backstack,
        entryProvider = { key ->
            when (key) {
                is CurrentsAppNavigationRoutes.LogIn -> {
                    NavEntry(key) {
                        LoginScreen {
                            pref.put(PrefKey.IsLogInSkipped, true)
                            backstack.remove(CurrentsAppNavigationRoutes.LogIn)
                            backstack.add(CurrentsAppNavigationRoutes.Currents)
                        }
                    }
                }

                is CurrentsAppNavigationRoutes.Currents -> {
                    NavEntry(key) {
                        CurrentsNavigationBaseScreen()
                    }
                }

                else -> error("Unknown navigation route $key")
            }
        }
    )
}