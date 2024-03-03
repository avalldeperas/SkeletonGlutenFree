package com.uoc.skeletonglutenfree.auth.presentation

data class LoginUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    var isUserLoggedIn: Boolean = false
)