package com.atech.currents.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = LuminaDarkPrimary,
    onPrimary = LuminaDarkOnPrimary,
    primaryContainer = LuminaDarkPrimaryContainer,
    onPrimaryContainer = LuminaDarkOnPrimaryContainer,
    inversePrimary = LuminaDarkInversePrimary,
    secondary = LuminaDarkSecondary,
    onSecondary = LuminaDarkOnSecondary,
    secondaryContainer = LuminaDarkSecondaryContainer,
    onSecondaryContainer = LuminaDarkOnSecondaryContainer,
    tertiary = LuminaDarkTertiary,
    onTertiary = LuminaDarkOnTertiary,
    tertiaryContainer = LuminaDarkTertiaryContainer,
    onTertiaryContainer = LuminaDarkOnTertiaryContainer,
    background = LuminaDarkBackground,
    onBackground = LuminaDarkOnBackground,
    surface = LuminaDarkSurface,
    onSurface = LuminaDarkOnSurface,
    surfaceVariant = LuminaDarkSurfaceVariant,
    onSurfaceVariant = LuminaDarkOnSurfaceVariant,
    outline = LuminaDarkOutline,
    outlineVariant = LuminaDarkOutlineVariant,
    inverseSurface = LuminaDarkInverseSurface,
    inverseOnSurface = LuminaDarkInverseOnSurface,
    surfaceTint = LuminaDarkSurfaceTint,
    error = LuminaDarkError,
    onError = LuminaDarkOnError,
    errorContainer = LuminaDarkErrorContainer,
    onErrorContainer = LuminaDarkOnErrorContainer,
    surfaceDim = LuminaDarkSurfaceDim,
    surfaceBright = LuminaDarkSurfaceBright,
    surfaceContainerLowest = LuminaDarkSurfaceContainerLowest,
    surfaceContainerLow = LuminaDarkSurfaceContainerLow,
    surfaceContainer = LuminaDarkSurfaceContainer,
    surfaceContainerHigh = LuminaDarkSurfaceContainerHigh,
    surfaceContainerHighest = LuminaDarkSurfaceContainerHighest
)

private val LightColorScheme = lightColorScheme(
    primary = LuminaLightPrimary,
    onPrimary = LuminaLightOnPrimary,
    primaryContainer = LuminaLightPrimaryContainer,
    onPrimaryContainer = LuminaLightOnPrimaryContainer,
    inversePrimary = LuminaLightInversePrimary,
    secondary = LuminaLightSecondary,
    onSecondary = LuminaLightOnSecondary,
    secondaryContainer = LuminaLightSecondaryContainer,
    onSecondaryContainer = LuminaLightOnSecondaryContainer,
    tertiary = LuminaLightTertiary,
    onTertiary = LuminaLightOnTertiary,
    tertiaryContainer = LuminaLightTertiaryContainer,
    onTertiaryContainer = LuminaLightOnTertiaryContainer,
    background = LuminaLightBackground,
    onBackground = LuminaLightOnBackground,
    surface = LuminaLightSurface,
    onSurface = LuminaLightOnSurface,
    surfaceVariant = LuminaLightSurfaceVariant,
    onSurfaceVariant = LuminaLightOnSurfaceVariant,
    outline = LuminaLightOutline,
    outlineVariant = LuminaLightOutlineVariant,
    inverseSurface = LuminaLightInverseSurface,
    inverseOnSurface = LuminaLightInverseOnSurface,
    surfaceTint = LuminaLightSurfaceTint,
    error = LuminaLightError,
    onError = LuminaLightOnError,
    errorContainer = LuminaLightErrorContainer,
    onErrorContainer = LuminaLightOnErrorContainer,
    surfaceDim = LuminaLightSurfaceDim,
    surfaceBright = LuminaLightSurfaceBright,
    surfaceContainerLowest = LuminaLightSurfaceContainerLowest,
    surfaceContainerLow = LuminaLightSurfaceContainerLow,
    surfaceContainer = LuminaLightSurfaceContainer,
    surfaceContainerHigh = LuminaLightSurfaceContainerHigh,
    surfaceContainerHighest = LuminaLightSurfaceContainerHighest
)

@Composable
fun CurrentsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val typography = if (darkTheme) LuminaDarkTypography else LuminaLightTypography

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}