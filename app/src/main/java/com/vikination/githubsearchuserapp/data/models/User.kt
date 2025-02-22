package com.vikination.githubsearchuserapp.data.models

data class User(
    val username : String,
    val avatarUrl : String,
    val bio :String,
    val company :String,
    val location :String,
    val name :String,
    val blog :String
){
    companion object{
        fun getEmptyUser(): User {
            return User(
                username = "N/A",
                avatarUrl = "",
                bio = "N/A",
                company = "N/A",
                location = "N/A",
                name = "N/A",
                blog = "N/A"
            )
        }
    }
}