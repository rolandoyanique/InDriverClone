package com.roli.indriveclone.presentation.screens.auth.login


import androidx.compose.foundation.layout.WindowInsets

import androidx.compose.foundation.layout.navigationBars

import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.roli.indriveclone.presentation.screens.auth.login.component.LoginContent


@Composable
fun LoginScreen(navController: NavHostController) {

    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars
    ){paddingValues ->
        LoginContent(navController,paddingValues)
    }
}