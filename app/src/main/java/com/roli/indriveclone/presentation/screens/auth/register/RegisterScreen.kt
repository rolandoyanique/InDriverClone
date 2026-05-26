package com.roli.indriveclone.presentation.screens.auth.register

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun RegisterScreen(navHostController: NavHostController) {
    Scaffold() { paddingValues ->
        Text(
            modifier = Modifier.padding(paddingValues),
            text="RegisterScreen"
            )
    }
}