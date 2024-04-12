package com.example.dragonspuzzles.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicToolbar(title: String) {
    TopAppBar(
        title = { Text(text = title, color = MaterialTheme.colorScheme.onPrimary)},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackToolbar(title: String, popUpScreen: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary),
        navigationIcon = {
        IconButton(
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            onClick = { popUpScreen() }) {
            Icon(Icons.Filled.ArrowBack, "")
        }
    })
}