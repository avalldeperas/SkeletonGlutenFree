package com.uoc.skeletonglutenfree.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.uoc.skeletonglutenfree.auth.ui.ForgotPasswordScreen
import com.uoc.skeletonglutenfree.auth.ui.LoginScreen
import com.uoc.skeletonglutenfree.auth.ui.SignUpScreen

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    data object Home : BottomBarScreen(
        route = Screens.HomeScreen.name,
        title = "Home",
        icon = Icons.Default.Home
    )

    data object Favorite : BottomBarScreen(
        route = Screens.FavoriteScreen.name,
        title = "Favourite",
        icon = Icons.Default.Favorite
    )

    data object Profile : BottomBarScreen(
        route = Screens.ProfileScreen.name,
        title = "Profile",
        icon = Icons.Default.Person
    )
}