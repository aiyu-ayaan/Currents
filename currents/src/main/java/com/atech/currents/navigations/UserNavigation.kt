package com.atech.currents.navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.atech.currents.ui.screens.dashboard.DashboardScreen
import com.atech.currents.ui.screens.expense.base.ExpenseScreen
import com.atech.currents.ui.screens.expense.details.ExpenseDetailsScreen
import com.atech.currents.ui.screens.links.LinksScreen
import kotlinx.serialization.Serializable

sealed interface UserNavigationRoutes : NavKey {
    @Serializable
    object Dashboard : NavKey, UserNavigationRoutes

    @Serializable
    object Expense : NavKey, UserNavigationRoutes

    @Serializable
    object Links : NavKey, UserNavigationRoutes

    @Serializable
    object Profile : NavKey, UserNavigationRoutes

    @Serializable
    object ExpenseDetails : NavKey, UserNavigationRoutes
}

@Composable
fun UserNavigation(
    modifier: Modifier = Modifier,
    backStack: NavBackStack<NavKey> = rememberNavBackStack()
) {

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryProvider = { key ->
            when (key) {
                is UserNavigationRoutes.Dashboard -> {
                    NavEntry(key) {
                        DashboardScreen()
                    }
                }

                is UserNavigationRoutes.Expense -> {
                    NavEntry(key) {
                        ExpenseScreen()
                    }
                }

                is UserNavigationRoutes.ExpenseDetails -> {
                    NavEntry(key) {
                        ExpenseDetailsScreen()
                    }
                }

                is UserNavigationRoutes.Links -> {
                    NavEntry(key) {
                        LinksScreen()
                    }
                }

                is UserNavigationRoutes.Profile -> {
                    NavEntry(key) {
                        // Profile Screen
                    }
                }

                else -> error("Unknown navigation route $key")
            }
        })
}


//composable<UserNavigationRoutes.Dashboard> {
//    DashboardScreen()
//}
//composable<UserNavigationRoutes.Expense> {
//    ExpenseScreen()
//}
//
//composable<UserNavigationRoutes.ExpenseDetails>{
//    ExpenseDetailsScreen()
//}
//
//composable<UserNavigationRoutes.Links> {
//    LinksScreen()
//}
//composable<UserNavigationRoutes.Profile> {
//    // to navigate use navController.navigate(Dashboard)
//}