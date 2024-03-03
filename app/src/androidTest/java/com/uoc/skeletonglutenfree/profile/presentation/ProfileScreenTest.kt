package com.uoc.skeletonglutenfree.profile.presentation

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
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

class ProfileScreenTest {

    @get:Rule
    val composeRule = createComposeRule()

    private val context: Context = ApplicationProvider.getApplicationContext()

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
                            onEditProfile = { /*TODO*/ },
                            onLogout = {}
                        )
                    }
                }
            }
        }
    }

    @Test
    fun startProfileScreen_thenElementsArePresent() {
        composeRule.onNodeWithContentDescription(context.getString(R.string.profile_image)).assertIsDisplayed()

        val toEditProfileBtn = composeRule.onNodeWithTag(TestTag.TO_EDIT_PROFILE_BTN)
        toEditProfileBtn.assertExists()
        toEditProfileBtn.assertTextContains(context.getString(R.string.to_edit_profile_text))

        val toLogoutBtn = composeRule.onNodeWithTag(TestTag.TO_LOGOUT_PROFILE_BTN)
        toLogoutBtn.assertExists()
        toLogoutBtn.assertTextContains(context.getString(R.string.logout_btn_text))
    }
}