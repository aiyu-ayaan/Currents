package com.atech.currents.ui.screens.expense.base

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.atech.ui.components.MainScreenLayout
import com.atech.ui.theme.CurrentsTheme
import com.atech.ui.theme.spacing

@OptIn(ExperimentalMaterial3AdaptiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ExpenseScreen(
    modifier: Modifier = Modifier
) {
    MainScreenLayout(
        modifier = modifier,
    ) { paddingValue, _ ->
        LazyColumn(
            modifier = Modifier.padding(MaterialTheme.spacing.medium),
            contentPadding = paddingValue,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(MaterialTheme.spacing.medium),
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ExpenseScreenPreview() {
    CurrentsTheme() {
        ExpenseScreen()
    }
}