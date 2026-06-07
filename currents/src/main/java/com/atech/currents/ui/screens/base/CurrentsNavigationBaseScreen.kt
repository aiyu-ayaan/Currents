package com.atech.currents.ui.screens.base

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.atech.ui.theme.CurrentsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrentsNavigationBaseScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Currents")
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CurrentsNavigationBaseScreenPreview() {
    CurrentsTheme {
        CurrentsNavigationBaseScreen()
    }
}