package com.vikination.githubsearchuserapp.data.models

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

data class User(
    val id : Int,
    val username : String,
    val avatarUrl : String,
    val bio :String,
    val company :String,
    val location :String,
    val name :String,
    val blog :String
){
    fun toUserEntity() :UserEntity{
        return UserEntity(
            id = id,
            username = username,
            avatarUrl = avatarUrl,
            name = name,
            company = company,
            blog = blog,
            location = location,
            bio = bio
        )
    }

    companion object{
        fun getEmptyUser(): User {
            return User(
                id = 0,
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
                id = 0,
                username = "vikination",
                avatarUrl = "https://cnmi.spmi.pt/wp-content/uploads/2014/10/speaker-3.jpg",
                bio = "this bio is very long, and long and long and long and loooooooooooong, so long ",
                company = "Vikination corp",
                location = "Bandung, Jawa Barat",
                name = "Viki Andrianto",
                blog = "vikiandrianto.my.id"
            )
        }

        private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val userAdapter :JsonAdapter<User> = moshi.adapter(User::class.java)
    }
}