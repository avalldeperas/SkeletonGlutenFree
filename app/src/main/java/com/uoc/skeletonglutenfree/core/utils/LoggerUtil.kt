package com.uoc.skeletonglutenfree.core.utils

import android.annotation.SuppressLint
import android.util.Log
import androidx.navigation.NavHostController

@SuppressLint("RestrictedApi")
fun logBackStack(navHostController: NavHostController) {
    Log.d("avb", "homeNav: ${navHostController.currentBackStack.value
        .map { it.destination.route }
        .joinToString(", ")}")
}
