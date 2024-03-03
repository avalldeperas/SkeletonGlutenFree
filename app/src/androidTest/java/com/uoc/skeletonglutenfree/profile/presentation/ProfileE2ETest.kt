package com.uoc.skeletonglutenfree.profile.presentation

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.core.app.ApplicationProvider
import com.uoc.skeletonglutenfree.R
import com.uoc.skeletonglutenfree.core.navigation.Screens
import com.uoc.skeletonglutenfree.core.utils.TestTag
import com.uoc.skeletonglutenfree.ui.theme.SkeletonGlutenFreeTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProfileE2ETest {

    private val context: Context = ApplicationProvider.getApplicationContext()

    @get:Rule
    val composeRule = createComposeRule()

    @Before
    fun setUp() {
        composeRule.setContent {
            val navController = rememberNavController()
            SkeletonGlutenFreeTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screens.ProfileScreen.name
                ) {
                    composable(route = Screens.ProfileScreen.name) {
                        ProfileScreen(
                            onEditProfile = { navController.navigate(Screens.EditProfileScreen.name) },
                            onLogout = {}
                        )
                    }
                    composable(route = Screens.EditProfileScreen.name) {
                        EditProfileScreen(
                            onPressBack = { navController.popBackStack() },
                            onSaveProfile = {})
                    }
                }
            }
        }
    }

    @Test
    fun onProfileScreen_whenPressToEditProfile_opensEditProfileScreen_andAbleToGoBackToProfile() {
        composeRule.onNodeWithTag(TestTag.TO_EDIT_PROFILE_BTN).performClick()
        composeRule.waitForIdle()
        composeRule.onNodeWithText(context.getString(R.string.edit_profile_header))
            .assertIsDisplayed()

        composeRule.onNodeWithTag(TestTag.BACK_TO_PROFILE).performClick()
        composeRule.waitForIdle()
        composeRule.onNodeWithText(context.getString(R.string.profile_screen_header))
            .assertIsDisplayed()
    }
}