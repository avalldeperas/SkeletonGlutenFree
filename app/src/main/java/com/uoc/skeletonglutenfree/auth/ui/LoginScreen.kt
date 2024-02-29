package com.uoc.skeletonglutenfree.auth.ui

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onLogin: () -> Unit,
    onForgotPassword: () -> Unit,
    onRegister: () -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Red) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Login Screen", fontSize = 24.sp)
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Button(onClick = { onLogin() }) {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Text(text = "Forgot Password?", modifier = Modifier.clickable {
                onForgotPassword()
            })
            Spacer(modifier = Modifier.padding(vertical = 32.dp))
            Text(text = "Don't have an account? Sign In", modifier = Modifier.clickable {
                onRegister()
            })

        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen({}, {}, {})
}