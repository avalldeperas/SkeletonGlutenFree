package com.uoc.skeletonglutenfree.map.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uoc.skeletonglutenfree.favourite.ui.FavoriteScreen
import com.uoc.skeletonglutenfree.navigation.Screens
import com.uoc.skeletonglutenfree.profile.ui.EditProfileScreen
import com.uoc.skeletonglutenfree.profile.ui.ProfileScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MapScreen(navController: NavHostController) {

//    Scaffold(
////        bottomBar = { BottomNavBar() }
//    ) {
//        NavHost(
//            navController = navController,
//            startDestination = Screens.MapScreen.name
//        ) {
//            navigationGraph(navController)
//        }
//    }
}

@Composable
fun MyMap(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Green) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Map Screen", fontSize = 24.sp)
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Spacer(modifier = Modifier.padding(vertical = 16.dp))

            Button(onClick = { navController.navigate(Screens.ListScreen.name) }) {
                Text(text = "List")
            }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
//    val navController = rememberNavController()
    var navigationSelectedItem by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar {
        //getting the list of bottom navigation items for our data class
        BottomNavigationItem().bottomNavigationItems().forEachIndexed { index, navigationItem ->
            NavigationBarItem(
                selected = index == navigationSelectedItem,
                label = {
                    Text(navigationItem.label)
                },
                icon = {
                    Icon(
                        navigationItem.icon,
                        contentDescription = navigationItem.label
                    )
                },
                onClick = {
                    navigationSelectedItem = index
                    navController.navigate(navigationItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
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

data class BottomNavigationItem(
    val label: String = "",
    val icon: ImageVector = Icons.Filled.Home,
    val route: String = ""
) {

    //function to get the list of bottomNavigationItems
    fun bottomNavigationItems(): List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Search",
                icon = Icons.Filled.Search,
                route = Screens.MapScreen.name
            ),
            BottomNavigationItem(
                label = "Favorite",
                icon = Icons.Filled.Favorite,
                route = Screens.FavoriteScreen.name
            ),
            BottomNavigationItem(
                label = "Profile",
                icon = Icons.Filled.AccountCircle,
                route = Screens.ProfileScreen.name
            )
        )
    }
}