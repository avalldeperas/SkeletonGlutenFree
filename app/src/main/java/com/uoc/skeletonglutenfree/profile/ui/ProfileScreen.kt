package com.uoc.skeletonglutenfree.profile.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(onEditProfile: () -> Unit, onLogout: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Green) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Profile Screen", fontSize = 24.sp)
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Spacer(modifier = Modifier.padding(vertical = 16.dp))

            Button(onClick = { onEditProfile() }) {
                Text(text = "Edit profile")
            }

            Button(onClick = { onLogout() }) {
                Text(text = "Logout")
            }
        }
    }
}
