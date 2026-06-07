package com.atech.currents.ui.screens.base

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AttachMoney
import androidx.compose.material.icons.twotone.Dashboard
import androidx.compose.material.icons.twotone.Link
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowSizeClass
import com.atech.currents.navigations.Dashboard
import com.atech.currents.navigations.Expense
import com.atech.currents.navigations.Links
import com.atech.currents.navigations.UserNavigation
import com.atech.ui.theme.CurrentsTheme


enum class AppDestinations(
    @param:StringRes val resId: Int, val imageVector: ImageVector
) {
    Dashboard(
        resId = com.atech.ui.R.string.Dashboard,
        imageVector = Icons.TwoTone.Dashboard
    ),
    Expense(
        resId = com.atech.ui.R.string.Expense,
        imageVector = Icons.TwoTone.AttachMoney
    ),
    Links(
        resId = com.atech.ui.R.string.Links,
        imageVector = Icons.TwoTone.Link
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrentsNavigationBaseScreen(
    modifier: Modifier = Modifier
) {
    val navHostController = rememberNavController()

    val adaptiveInfo = currentWindowAdaptiveInfoV2()
    val sizeClass = adaptiveInfo.windowSizeClass

    val layoutType = when {
        sizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND) -> {
            NavigationSuiteType.NavigationDrawer
        }

        sizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND) -> {
            NavigationSuiteType.NavigationRail
        }

        else -> {
            NavigationSuiteType.NavigationBar
        }
    }
    var selectedItem: AppDestinations by remember { mutableStateOf(AppDestinations.Dashboard) }

    NavigationSuiteScaffold(
        modifier = modifier,
        layoutType = layoutType,
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    selected = selectedItem == it,
                    onClick = {
                        selectedItem = it
                        when (it) {
                            AppDestinations.Dashboard -> navHostController.navigate(Dashboard)
                            AppDestinations.Expense -> navHostController.navigate(Expense)
                            AppDestinations.Links -> navHostController.navigate(Links)
                        }
                    },
                    icon = { Icon(imageVector = it.imageVector, null) },
                    label = { Text(text = stringResource(it.resId)) })
            }
        }) {

        UserNavigation(
            navHostController = navHostController,
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