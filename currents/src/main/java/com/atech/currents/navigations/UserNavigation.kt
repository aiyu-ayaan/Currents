package com.atech.currents.navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.atech.currents.ui.screens.dashboard.DashboardScreen
import com.atech.currents.ui.screens.expense.base.ExpenseScreen
import com.atech.currents.ui.screens.expense.details.ExpenseDetailsScreen
import com.atech.currents.ui.screens.links.LinksScreen
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
object Dashboard

@Serializable
object Expense

@Serializable
object Links

@Serializable
object Profile

@Serializable
object ExpenseDetails

@Composable
fun UserNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: KClass<*> = Dashboard::class
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination
    ) {

        composable<Dashboard> {
            DashboardScreen()
        }
        composable<Expense> {
            ExpenseScreen()
        }

        composable<ExpenseDetails>{
            ExpenseDetailsScreen()
        }

        composable<Links> {
            LinksScreen()
        }
        composable<Profile> {
            // to navigate use navController.navigate(Dashboard)
        }
    }
}