package com.vikination.githubsearchuserapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username : String,
    val avatarUrl : String,
    val bio :String,
    val company :String,
    val location :String,
    val name :String,
    val blog :String
){
    fun toUser() :User{
        return User(
            id = id,
            username = username,
            avatarUrl = avatarUrl,
            bio = bio,
            company = company,
            location = location,
            name = name,
            blog = blog
        )
    }
}