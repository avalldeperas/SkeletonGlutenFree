package com.uoc.skeletonglutenfree.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uoc.skeletonglutenfree.favourite.ui.FavoriteScreen
import com.uoc.skeletonglutenfree.map.ui.DetailRestaurantScreen
import com.uoc.skeletonglutenfree.map.ui.ListScreen
import com.uoc.skeletonglutenfree.map.ui.MyMap
import com.uoc.skeletonglutenfree.profile.ui.EditProfileScreen
import com.uoc.skeletonglutenfree.profile.ui.ProfileScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = Screens.HomeScreen.name
    ) {
        navigationGraph(navController)
    }
}

// NavGraph
fun NavGraphBuilder.navigationGraph(navController: NavHostController) {

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