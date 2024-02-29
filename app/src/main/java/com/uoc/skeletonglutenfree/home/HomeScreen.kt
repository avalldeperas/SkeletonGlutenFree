package com.uoc.skeletonglutenfree.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
            startDestination = Screens.MapScreen.name
        ) {
            homeNav(navController)
        }
    }
}

fun NavGraphBuilder.homeNav(navController: NavHostController) {

    composable(Screens.FavoriteScreen.name) {
        FavoriteScreen(navController)
    }

    composable(Screens.MapScreen.name) {
        MyMap(navController)
    }

    composable(Screens.ListScreen.name) {
        ListScreen(navController)
    }

    composable(Screens.DetailRestaurantScreen.name) {
        DetailRestaurantScreen(navController)
    }

    composable(Screens.ProfileScreen.name) {
        ProfileScreen(navController)
    }

    composable(Screens.EditProfileScreen.name) {
        EditProfileScreen(navController)
    }
}
