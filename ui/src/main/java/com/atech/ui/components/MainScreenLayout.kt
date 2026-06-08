package com.atech.ui.components

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.atech.core.utils.LogsTag

/**
 * A reusable layout composable for main screens in the app,
 * providing a consistent structure with a top app bar, optional FAB, and content area.
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenLayout(
    modifier: Modifier = Modifier,
    @StringRes title: Int = com.atech.ui.R.string.app_name,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    isHaveFab: Boolean = false,
    fabPosition: FabPosition = FabPosition.End,
    onFabClick: () -> Unit = { },
    navigateUp: (() -> Unit)? = null,
    actions: @Composable (RowScope.() -> Unit) = {},
    content: @Composable (PaddingValues, SnackbarHostState) -> Unit = { _, _ -> }
) {
    val navigationIcons: @Composable (() -> Unit) = if (navigateUp != null) {
        @Composable {
            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = null
                )
            }
        }
    } else {
        @Composable { }
    }

    val fabButton: @Composable () -> Unit = if (isHaveFab) {
        @Composable {
            FloatingActionButton(onClick = onFabClick) {
                Icon(
                    imageVector = Icons.Default.Settings, contentDescription = null
                )
            }
        }
    } else {
        @Composable { }
    }

    val mScrollBehavior = scrollBehavior ?: TopAppBarDefaults.pinnedScrollBehavior(
        rememberTopAppBarState()
    )

    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        modifier = modifier
            .nestedScroll(mScrollBehavior.nestedScrollConnection),
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = title)) },
                navigationIcon = navigationIcons,
                actions = actions,
                scrollBehavior = mScrollBehavior
            )
        },
        floatingActionButton = fabButton,
        floatingActionButtonPosition = fabPosition,
        content = {
            if (!isHaveFab && onFabClick != { }) {
                Log.d(
                    LogsTag.UiLogs.name,
                    "MainScreenLayout: FAB click listener provided but FAB is not shown. Please set isHaveFab to true."
                )
            }
            content(it, snackBarHostState)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun MainScreenLayoutPreview() {
    MainScreenLayout(
        navigateUp = {},
        isHaveFab = true,
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Settings, contentDescription = null
                )
            }
        }
    )
}
