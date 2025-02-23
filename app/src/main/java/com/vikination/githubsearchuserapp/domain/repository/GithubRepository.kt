package com.vikination.githubsearchuserapp.domain.repository

import com.vikination.githubsearchuserapp.data.models.ResultState
import com.vikination.githubsearchuserapp.data.models.User
import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    fun getCachedUsers() :Flow<List<User>>
    fun searchUser(query: String): Flow<ResultState<List<User>>>
    fun getUserDetail(username :String) :Flow<ResultState<User>>
}