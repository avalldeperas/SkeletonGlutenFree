package com.uoc.skeletonglutenfree

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uoc.skeletonglutenfree.auth.ui.ForgotPasswordScreen
import com.uoc.skeletonglutenfree.auth.ui.LoginScreen
import com.uoc.skeletonglutenfree.auth.ui.SignUpScreen
import com.uoc.skeletonglutenfree.map.ui.MapScreen
import com.uoc.skeletonglutenfree.navigation.Screens

//@HiltAndroidApp
//class SkeletonGFApp {

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.LoginScreen.name
    ) {
        authGraph(navController)
        composable(Screens.MapScreen.name) {
            MapScreen(navController)
        }
    }
}


fun NavGraphBuilder.authGraph(navController: NavController) {

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



