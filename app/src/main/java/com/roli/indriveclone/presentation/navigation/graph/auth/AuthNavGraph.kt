package com.roli.indriveclone.presentation.navigation.graph.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.roli.indriveclone.presentation.navigation.Graph
import com.roli.indriveclone.presentation.navigation.screen.auth.AuthScreen
import com.roli.indriveclone.presentation.screens.auth.login.LoginScreen
import com.roli.indriveclone.presentation.screens.auth.register.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController)  {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){ LoginScreen(navController) }
        composable(route = AuthScreen.Register.route){ RegisterScreen(navController)}
    }
}