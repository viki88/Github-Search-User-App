package com.vikination.githubsearchuserapp.ui.screens

sealed class Screen(val route :String) {
    data object Home : Screen("user_list")
    data object Detail : Screen("user_list/{username}"){
        fun createRoute(username: String) = "user_list/$username"
    }
}