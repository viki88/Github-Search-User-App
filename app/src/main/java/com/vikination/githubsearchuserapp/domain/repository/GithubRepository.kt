package com.vikination.githubsearchuserapp.domain.repository

import com.vikination.githubsearchuserapp.data.models.User
import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    fun getUsers() :Flow<List<User>>
    fun searchUser(query: String): Flow<List<User>>
    fun getUserDetail(username :String) :Flow<User>
}