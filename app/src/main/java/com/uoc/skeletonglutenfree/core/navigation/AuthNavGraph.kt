package com.uoc.skeletonglutenfree.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.uoc.skeletonglutenfree.auth.presentation.ForgotPasswordScreen
import com.uoc.skeletonglutenfree.auth.presentation.LoginScreen
import com.uoc.skeletonglutenfree.auth.presentation.SignUpScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = Screens.LoginScreen.name
    ) {
        composable(Screens.LoginScreen.name) {
            LoginScreen(
                onLogin = { navController.navigate(Screens.HomeScreen.name) },
                onRegister = { navController.navigate(Screens.SignUpScreen.name) },
                onForgotPassword = { navController.navigate(Screens.ForgotPassword.name) }
            )
        }

        composable(Screens.SignUpScreen.name) {
            SignUpScreen(
                onRegister = { navController.navigate(Screens.HomeScreen.name) },
                onReturnToLogin = { navController.popBackStack() }
            )
        }

        composable(Screens.ForgotPassword.name) {
            ForgotPasswordScreen(
                onReturnToLogin = { navController.popBackStack() }
            )
        }
    }
}