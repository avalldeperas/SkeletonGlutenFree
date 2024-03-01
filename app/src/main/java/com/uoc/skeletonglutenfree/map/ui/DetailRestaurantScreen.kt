package com.uoc.skeletonglutenfree.map.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailRestaurantScreen(onPressBack: () -> Unit) {

    Button(onClick = { onPressBack() }) {
        Text("Go Back")
    }

}
