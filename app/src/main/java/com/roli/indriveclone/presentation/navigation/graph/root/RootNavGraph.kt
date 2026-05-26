package com.roli.indriveclone.presentation.navigation.graph.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.roli.indriveclone.presentation.navigation.Graph
import com.roli.indriveclone.presentation.navigation.graph.auth.AuthNavGraph

@Composable
fun RootNavGraph(navHostController: NavHostController) {
    NavHost(
        navController=navHostController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ){
AuthNavGraph(navHostController)
    }
}