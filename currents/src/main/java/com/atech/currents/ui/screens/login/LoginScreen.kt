package com.atech.currents.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atech.ui.R
import com.atech.ui.theme.CurrentsTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize( )
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center

        ) {
            Image(
                painter = painterResource(R.drawable.svg_login_screen),
                contentDescription = "Login Screen Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.4f)
            )
//            Image(painter = painterResource(com.atech.currents.R.mipmap.ic_launcher), contentDescription = "Currents Logo")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    CurrentsTheme() {
        LoginScreen()
    }
}