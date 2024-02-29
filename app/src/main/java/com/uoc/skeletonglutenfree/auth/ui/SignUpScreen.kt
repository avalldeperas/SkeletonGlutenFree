package com.uoc.skeletonglutenfree.auth.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uoc.skeletonglutenfree.navigation.Screens

@Composable
fun SignUpScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Cyan) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "SignUp Screen", fontSize = 24.sp)
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Text(text = "Already have an account? Log In", modifier = Modifier.clickable {
                navController.navigate(Screens.LoginScreen.name)
            })
        }
    }
}