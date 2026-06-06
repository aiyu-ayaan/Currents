package com.atech.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atech.ui.R
import com.atech.ui.theme.CurrentsTheme
import com.atech.ui.theme.spacing

@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconId: Int,
    @StringRes textId: Int,
    isLoading: Boolean = false,
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        modifier = modifier, onClick = onClick, enabled = !isLoading
    ) {
        Row(
            modifier = Modifier.padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            AnimatedContent(
                targetState = isLoading, label = "LoadingAnimation"
            ) { loading ->

                if (loading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(18.dp), strokeWidth = 2.dp
                    )
                } else {
                    Image(
                        painter = painterResource(id = iconId),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = if (isLoading) stringResource(R.string.signing_in)
                else stringResource(id = textId)
            )
        }
    }
}


@Composable
fun AppButton1(
    modifier: Modifier = Modifier,
    @StringRes textId: Int,
    @DrawableRes iconId: Int? = null,
    imageVector: ImageVector? = null,
    textColor: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit = {}
) {
    TextButton(onClick = {}) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (iconId != null) {
                Image(
                    painter = painterResource(id = iconId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(18.dp)
                        .padding(end = MaterialTheme.spacing.medium),
                    colorFilter = null
                )
            } else if (imageVector != null) {
                Image(
                    imageVector = imageVector,
                    contentDescription = null,
                    modifier = Modifier
                        .size(18.dp)
                        .padding(end = MaterialTheme.spacing.medium),
                    colorFilter = null
                )
            }
            Text(text = stringResource(id = textId))
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun LoginButtonsPreview() {
    CurrentsTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.large),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginButton(
                iconId = R.drawable.ic_google, textId = R.string.login_with_google
            )
            LoginButton(
                iconId = R.drawable.ic_github, textId = R.string.login_with_github
            )

            AppButton1(
                textId = R.string.skip
            )
        }
    }
}
