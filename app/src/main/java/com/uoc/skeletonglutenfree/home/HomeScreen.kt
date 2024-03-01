package com.uoc.skeletonglutenfree.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uoc.skeletonglutenfree.auth.ui.LoginScreen
import com.uoc.skeletonglutenfree.favourite.ui.FavoriteScreen
import com.uoc.skeletonglutenfree.map.ui.BottomNavBar
import com.uoc.skeletonglutenfree.map.ui.DetailRestaurantScreen
import com.uoc.skeletonglutenfree.map.ui.ListScreen
import com.uoc.skeletonglutenfree.map.ui.MyMap
import com.uoc.skeletonglutenfree.navigation.Screens
import com.uoc.skeletonglutenfree.profile.ui.EditProfileScreen
import com.uoc.skeletonglutenfree.profile.ui.ProfileScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreen.name
        ) {
            homeNav(navController)
        }
    }
}

fun NavGraphBuilder.homeNav(navController: NavHostController) {

    composable(Screens.FavoriteScreen.name) {
        FavoriteScreen()
    }

    composable(Screens.HomeScreen.name) {
        MyMap(onPressList = { navController.navigate(Screens.ListScreen.name) })
    }

    composable(Screens.ListScreen.name) {
        ListScreen(onMapPress = { navController.navigate(Screens.HomeScreen.name) })
    }

    composable(Screens.DetailRestaurantScreen.name) {
        DetailRestaurantScreen(onPressBack = { navController.popBackStack() })
    }

    composable(Screens.ProfileScreen.name) {
        ProfileScreen(
            onEditProfile = { navController.navigate(Screens.EditProfileScreen.name) },
            onLogout = {
                // TODO: pending to implement better, currently going to the default login screen
                navController.navigate(Screens.LoginScreen.name) {
                    popUpTo(0)
                }
            }
        )
    }

    composable(Screens.EditProfileScreen.name) {
        EditProfileScreen(
            onPressBack = { navController.popBackStack() },
            onSaveProfile = {}
        )
    }

    composable(Screens.LoginScreen.name) {
        LoginScreen({ }, {}, {})
    }
}
