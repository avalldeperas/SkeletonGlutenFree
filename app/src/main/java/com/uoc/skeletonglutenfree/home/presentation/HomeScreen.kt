package com.uoc.skeletonglutenfree.home.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uoc.skeletonglutenfree.auth.presentation.LoginScreen
import com.uoc.skeletonglutenfree.favourite.presentation.FavoriteScreen
import com.uoc.skeletonglutenfree.map.presentation.BottomNavBar
import com.uoc.skeletonglutenfree.map.presentation.DetailRestaurantScreen
import com.uoc.skeletonglutenfree.map.presentation.ListScreen
import com.uoc.skeletonglutenfree.map.presentation.MyMap
import com.uoc.skeletonglutenfree.core.navigation.Screens
import com.uoc.skeletonglutenfree.profile.presentation.EditProfileScreen
import com.uoc.skeletonglutenfree.profile.presentation.ProfileScreen

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
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
        MyMap(
            onPressList = { navController.navigate(Screens.ListScreen.name) },
            navigateToDetail = { navController.navigate(Screens.DetailRestaurantScreen.name) }
        )
    }

    composable(Screens.ListScreen.name) {
        ListScreen(
            onMapPress = { navController.navigate(Screens.HomeScreen.name) },
            navigateToDetail = { navController.navigate(Screens.DetailRestaurantScreen.name) }
        )
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
