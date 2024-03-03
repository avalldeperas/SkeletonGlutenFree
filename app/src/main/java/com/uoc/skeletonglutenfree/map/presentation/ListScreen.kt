package com.uoc.skeletonglutenfree.map.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun ListScreen(onMapPress: () -> Unit, navigateToDetail: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Yellow) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "List Screen", fontSize = 24.sp)
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Button(onClick = { onMapPress() }) {
                Text(text = "Map")
            }
            Spacer(modifier = Modifier.padding(vertical = 16.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navigateToDetail() }
            ) {
                Text(text = "Racó del Pla Detall")
            }
        }
    }

}
