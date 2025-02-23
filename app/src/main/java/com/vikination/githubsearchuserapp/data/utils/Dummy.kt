package com.vikination.githubsearchuserapp.data.utils

import com.vikination.githubsearchuserapp.data.models.GithubUser
import com.vikination.githubsearchuserapp.data.models.User
import com.vikination.githubsearchuserapp.data.models.UserEntity

class Dummy {
    companion object{
        fun getDummyUser(): User {
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

        fun getDummyUserEntity(): UserEntity = getDummyUser().toUserEntity()

        fun getDummyGithubUser(): GithubUser =
            GithubUser(
                id = 0,
                login = "vikination",
                avatarUrl = "https://cnmi.spmi.pt/wp-content/uploads/2014/10/speaker-3.jpg",
                bio = "this bio is very long, and long and long and long and loooooooooooong, so long ",
                company = "Vikination corp",
                location = "Bandung, Jawa Barat",
                name = "Viki Andrianto",
                blog = "vikiandrianto.my.id"
            )
    }
}