package com.atech.currents.ui.screens.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atech.ui.theme.CurrentsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoScreen(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
    onThemeToggle: (Boolean) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Theme Demonstration") },
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        Text(
                            text = if (isDarkTheme) "Dark Theme" else "Light Theme",
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Switch(
                            checked = isDarkTheme,
                            onCheckedChange = onThemeToggle
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                scrollBehavior = scrollBehavior
            )
        },
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                Text(
                    text = "Welcome to Currents",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "This screen showcases the dynamic color palette, custom typography, and Material 3 components configured in your :ui module theme.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            item {
                SectionHeader("Color Palette")
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ColorRow(
                        "Primary", MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.onPrimary,
                        "Primary Container", MaterialTheme.colorScheme.primaryContainer, MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    ColorRow(
                        "Secondary", MaterialTheme.colorScheme.secondary, MaterialTheme.colorScheme.onSecondary,
                        "Secondary Container", MaterialTheme.colorScheme.secondaryContainer, MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    ColorRow(
                        "Tertiary", MaterialTheme.colorScheme.tertiary, MaterialTheme.colorScheme.onTertiary,
                        "Tertiary Container", MaterialTheme.colorScheme.tertiaryContainer, MaterialTheme.colorScheme.onTertiaryContainer
                    )
                    ColorRow(
                        "Background", MaterialTheme.colorScheme.background, MaterialTheme.colorScheme.onBackground,
                        "Surface", MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.onSurface
                    )
                    ColorRow(
                        "Error", MaterialTheme.colorScheme.error, MaterialTheme.colorScheme.onError,
                        "Error Container", MaterialTheme.colorScheme.errorContainer, MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }

            item {
                SectionHeader("Typography Hierarchy")
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text("Display Large", style = MaterialTheme.typography.displayLarge)
                        Text("Headline Large", style = MaterialTheme.typography.headlineLarge)
                        Text("Title Large", style = MaterialTheme.typography.titleLarge)
                        Text("Body Large: Used for standard paragraphs.", style = MaterialTheme.typography.bodyLarge)
                        Text("Body Medium: Secondary body descriptions.", style = MaterialTheme.typography.bodyMedium)
                        Text("Label Large: Action button captions.", style = MaterialTheme.typography.labelLarge)
                    }
                }
            }

            item {
                SectionHeader("Interactive Components")
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(onClick = {}) {
                                Text("Filled Button")
                            }
                            ElevatedButton(onClick = {}) {
                                Text("Elevated")
                            }
                            OutlinedButton(onClick = {}) {
                                Text("Outlined")
                            }
                        }

                        var textValue by remember { mutableStateOf("") }
                        OutlinedTextField(
                            value = textValue,
                            onValueChange = { textValue = it },
                            label = { Text("Theme Input Field") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Material Checkbox State", style = MaterialTheme.typography.bodyMedium)
                            var checkedState by remember { mutableStateOf(true) }
                            Checkbox(checked = checkedState, onCheckedChange = { checkedState = it })
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(bottom = 12.dp)
    )
}

@Composable
fun RowScope.ColorCard(
    name: String,
    backgroundColor: Color,
    textColor: Color
) {
    Box(
        modifier = Modifier
            .weight(1f)
            .height(72.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .padding(12.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = textColor
            )
            Text(
                text = String.format("#%08X", backgroundColor.toArgb()),
                fontSize = 11.sp,
                color = textColor.copy(alpha = 0.8f)
            )
        }
    }
}

@Composable
fun ColorRow(
    name1: String, color1: Color, text1: Color,
    name2: String, color2: Color, text2: Color
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        ColorCard(name1, color1, text1)
        ColorCard(name2, color2, text2)
    }
}

@Preview(showBackground = true)
@Composable
private fun DemoScreenPreview() {
    CurrentsTheme {
        DemoScreen(
            isDarkTheme = false,
            onThemeToggle = {}
        )
    }
}