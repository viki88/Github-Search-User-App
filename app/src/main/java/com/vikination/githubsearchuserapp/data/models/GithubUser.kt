package com.vikination.githubsearchuserapp.data.models

import com.squareup.moshi.Json

data class GithubUser(
    @Json(name = "login") val login : String?,
    @Json(name = "avatar_url") val avatarUrl : String?,
    @Json(name = "name") val name : String?,
    @Json(name = "company") val company : String?,
    @Json(name = "blog") val blog : String?,
    @Json(name = "location") val location : String?,
    @Json(name = "bio") val bio : String?,
){
    fun toUser(): User {
        return User(
            username = login ?: "N/A",
            avatarUrl = avatarUrl ?: "N/A",
            name = name ?: "N/A",
            company = company ?: "N/A",
            blog = blog ?: "N/A",
            location = location ?: "N/A",
            bio = bio ?: "N/A"
        )
    }
}