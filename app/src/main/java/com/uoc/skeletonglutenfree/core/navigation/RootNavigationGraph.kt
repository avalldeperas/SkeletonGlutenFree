package com.uoc.skeletonglutenfree.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uoc.skeletonglutenfree.home.presentation.HomeScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navController)
        composable(route = Screens.HomeScreen.name) {
            HomeScreen()
        }
    }
}
