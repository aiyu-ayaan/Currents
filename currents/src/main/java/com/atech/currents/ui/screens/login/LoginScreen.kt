package com.atech.currents.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atech.core.data.local.pref.PrefKey
import com.atech.currents.ui.activities.main.LocalPrefProvider
import com.atech.ui.R
import com.atech.ui.components.AppButton1
import com.atech.ui.components.LoginButton
import com.atech.ui.theme.CurrentsTheme
import com.atech.ui.theme.spacing

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigationToAppNavigation : () -> Unit = { }
) {



    var isGoogleButtonLoading : Boolean  by remember { mutableStateOf(false) }
    var isGithubButtonLoading : Boolean  by remember { mutableStateOf(false) }
    Scaffold(
        modifier = modifier.fillMaxSize( )
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(
                    horizontal = MaterialTheme.spacing.large,
                    vertical = MaterialTheme.spacing.largePlus
                ),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,

        ) {
            Image(
                painter = painterResource(R.drawable.img_login_screen),
                contentDescription = "Login Screen Image",
                modifier = Modifier
                    .aspectRatio(16f / 9f)
                    .fillMaxWidth()
                    .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(MaterialTheme.spacing.large)),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))
            Box(
                modifier = modifier
                    .size(52.dp)
                    .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(MaterialTheme.spacing.large))
                    .background(MaterialTheme.colorScheme.primary),
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_logo),
                    contentDescription = "Google Icon",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                )
            }
            Text(
                text = stringResource(com.atech.currents.R.string.app_name),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = MaterialTheme.spacing.medium)
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
            Text(
                text = stringResource(com.atech.currents.R.string.effortless_management_for_your_daily_workflows),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = MaterialTheme.spacing.small),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))
            LoginButton(
                iconId = R.drawable.ic_google,
                textId = R.string.login_with_google,
                isLoading = isGoogleButtonLoading
            ){
                isGoogleButtonLoading = !isGoogleButtonLoading
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            LoginButton(
                iconId = R.drawable.ic_github,
                textId = R.string.login_with_github,
                isLoading = isGithubButtonLoading
            ){
                isGithubButtonLoading = !isGithubButtonLoading
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            AppButton1(
                textId = R.string.skip,
            ){
                navigationToAppNavigation()
            }
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