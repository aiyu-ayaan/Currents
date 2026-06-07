package com.atech.currents.navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.atech.core.data.local.pref.PrefKey
import com.atech.currents.ui.activities.main.LocalPrefProvider
import com.atech.currents.ui.screens.base.CurrentsNavigationBaseScreen
import com.atech.currents.ui.screens.login.LoginScreen
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass


@Serializable object LogIn

// routes for nested navigation
@Serializable object Currents

@Composable
fun CurrentsAppNavigationEntry(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: KClass<*> = LogIn::class
) {
    val pref = LocalPrefProvider.current
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable<LogIn>{
            LoginScreen{
                pref.put(PrefKey.IsLogInSkipped, true)
                navHostController.navigate(Currents) {
                    popUpTo(LogIn) {
                        inclusive = true
                    }
                }
            }
        }

        composable<Currents>{
            CurrentsNavigationBaseScreen()
        }

//        navigation<Currents>(startDestination = Dashboard) {
//            composable<Dashboard> {
//                // to navigate use navController.navigate(Expense)
//            }
//            composable<Expense> {
//                // to navigate use navController.navigate(Links)
//            }
//            composable<Links> {
//                // to navigate use navController.navigate(Profile)
//            }
//            composable<Profile> {
//                // to navigate use navController.navigate(Dashboard)
//            }
//        }
    }
}