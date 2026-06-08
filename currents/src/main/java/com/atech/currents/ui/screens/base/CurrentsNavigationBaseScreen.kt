package com.atech.currents.ui.screens.base

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AttachMoney
import androidx.compose.material.icons.twotone.Dashboard
import androidx.compose.material.icons.twotone.Link
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.atech.currents.navigations.Dashboard
import com.atech.currents.navigations.Expense
import com.atech.currents.navigations.Links
import com.atech.currents.navigations.UserNavigation
import com.atech.ui.theme.CurrentsTheme


enum class AppDestinations(
    @param:StringRes val resId: Int,
    val imageVector: ImageVector
) {
    DestinationDashboard(
        resId = com.atech.ui.R.string.Dashboard,
        imageVector = Icons.TwoTone.Dashboard
    ),
    DestinationExpense(
        resId = com.atech.ui.R.string.Expense,
        imageVector = Icons.TwoTone.AttachMoney
    ),
    DestinationLinks(
        resId = com.atech.ui.R.string.Links,
        imageVector = Icons.TwoTone.Link
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrentsNavigationBaseScreen(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomAppBar {
                AppDestinations.entries.forEach { destination ->

                    val selected = when (destination) {
                        AppDestinations.DestinationDashboard ->
                            currentRoute == Dashboard::class.qualifiedName

                        AppDestinations.DestinationExpense ->
                            currentRoute == Expense::class.qualifiedName

                        AppDestinations.DestinationLinks ->
                            currentRoute == Links::class.qualifiedName
                    }

                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = destination.imageVector,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(stringResource(destination.resId))
                        },
                        selected = selected,
                        onClick = {
                            when (destination) {
                                AppDestinations.DestinationDashboard ->
                                    navController.navigate(Dashboard)

                                AppDestinations.DestinationExpense ->
                                    navController.navigate(Expense)

                                AppDestinations.DestinationLinks ->
                                    navController.navigate(Links)
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        UserNavigation(
            modifier = Modifier.padding(
                PaddingValues(
                    bottom = paddingValues.calculateBottomPadding(),
                    top = 0.dp
                )
            ),
            navHostController = navController,
            startDestination = Dashboard::class
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CurrentsNavigationBaseScreenPreview() {
    CurrentsTheme {
        CurrentsNavigationBaseScreen()
    }
}