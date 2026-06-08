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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import com.atech.currents.navigations.UserNavigation
import com.atech.currents.navigations.UserNavigationRoutes
import com.atech.ui.theme.CurrentsTheme


enum class AppDestinations(
    @param:StringRes val resId: Int,
    val imageVector: ImageVector,
    val navKey: NavKey
) {
    DestinationDashboard(
        resId = com.atech.ui.R.string.Dashboard,
        imageVector = Icons.TwoTone.Dashboard,
        navKey = UserNavigationRoutes.Dashboard
    ),
    DestinationExpense(
        resId = com.atech.ui.R.string.Expense,
        imageVector = Icons.TwoTone.AttachMoney,
        navKey = UserNavigationRoutes.Expense
    ),
    DestinationLinks(
        resId = com.atech.ui.R.string.Links,
        imageVector = Icons.TwoTone.Link,
        navKey = UserNavigationRoutes.Links
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrentsNavigationBaseScreen(
    modifier: Modifier = Modifier
) {
    val backstack = rememberNavBackStack(UserNavigationRoutes.Expense)
    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomAppBar {
                AppDestinations.entries.forEach { destination ->
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
                        selected = backstack.last() == destination.navKey,
                        onClick = {
                            when (destination) {
                                AppDestinations.DestinationDashboard ->
                                    backstack.add(UserNavigationRoutes.Dashboard)

                                AppDestinations.DestinationExpense ->
                                    backstack.add(UserNavigationRoutes.Expense)

                                AppDestinations.DestinationLinks ->
                                    backstack.add(UserNavigationRoutes.Links)
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
            backStack = backstack
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