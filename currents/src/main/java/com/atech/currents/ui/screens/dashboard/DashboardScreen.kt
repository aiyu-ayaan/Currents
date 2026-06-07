package com.atech.currents.ui.screens.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.atech.ui.theme.CurrentsTheme

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(text = "Dashboard Screen")
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    CurrentsTheme() {
        DashboardScreen()
    }
}