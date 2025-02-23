package com.vikination.githubsearchuserapp.ui.screens

import android.net.Uri

sealed class Screen(val route :String) {
    data object Home : Screen("user_list")
    data object Detail : Screen("user_detail/{username}"){
        fun createRoute(username: String) = "user_detail/${username}"
    }
}