package com.uoc.skeletonglutenfree.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.uoc.skeletonglutenfree.auth.ui.ForgotPasswordScreen
import com.uoc.skeletonglutenfree.auth.ui.LoginScreen
import com.uoc.skeletonglutenfree.auth.ui.SignUpScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = Screens.LoginScreen.name
    ) {
        composable(Screens.LoginScreen.name) {
            LoginScreen(navController)
        }

        composable(Screens.SignUpScreen.name) {
            SignUpScreen(navController)
        }

        composable(Screens.ForgotPassword.name) {
            ForgotPasswordScreen(navController)
        }
    }
}