package com.atech.currents.ui.screens.links

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.atech.ui.theme.CurrentsTheme

@Composable
fun LinksScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Link Screen")
    }
}

@Preview(showBackground = true)
@Composable
private fun LinksScreenPreview() {
    CurrentsTheme() {
        LinksScreen()
    }
}