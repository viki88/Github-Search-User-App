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

        fun getDummyUser(): User{
            return User(
                username = "vikination",
                avatarUrl = "https://cnmi.spmi.pt/wp-content/uploads/2014/10/speaker-3.jpg",
                bio = "this bio is very long, and long and long and long and loooooooooooong, so long ",
                company = "Vikination corp",
                location = "Bandung, Jawa Barat",
                name = "Viki Andrianto",
                blog = "vikiandrianto.my.id"
            )
        }
    }
}