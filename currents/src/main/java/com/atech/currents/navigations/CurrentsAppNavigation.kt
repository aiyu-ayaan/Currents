package com.atech.currents.navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass


@Serializable object LogIn

// routes for nested navigation
@Serializable object Currents

// routes for nested navigation Currents
@Serializable object Dashboard
@Serializable object Expense
@Serializable object Links
@Serializable object Profile

@Composable
fun CurrentsAppNavigationEntry(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: KClass<*> = LogIn::class
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable<LogIn>{
            // to navigate use navController.navigate(Current)
        }

        navigation<Currents>(startDestination = Dashboard) {
            composable<Dashboard> {
                // to navigate use navController.navigate(Expense)
            }
            composable<Expense> {
                // to navigate use navController.navigate(Links)
            }
            composable<Links> {
                // to navigate use navController.navigate(Profile)
            }
            composable<Profile> {
                // to navigate use navController.navigate(Dashboard)
            }
        }
    }
}