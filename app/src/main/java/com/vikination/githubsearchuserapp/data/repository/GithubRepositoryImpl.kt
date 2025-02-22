package com.vikination.githubsearchuserapp.data.repository

import com.vikination.githubsearchuserapp.data.models.User
import com.vikination.githubsearchuserapp.data.source.remote.GithubApiService
import com.vikination.githubsearchuserapp.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor (private val githubApiService: GithubApiService) :GithubRepository {

    /**
     * Get users from Github API
     */
    override fun getUsers(): Flow<List<User>> = flow {
        try {
            emit(githubApiService.getUsers().map { it.toUser() })
        }catch (e: Exception){
            e.printStackTrace()
            emit(emptyList())
        }
    }

    /**
     * Get user detail from Github API
     */
    override fun getUserDetail(username: String): Flow<User> = flow {
        try {
            emit(githubApiService.getUserDetail(username).toUser())
        } catch (e: Exception) {
            e.printStackTrace()
            emit(User.getEmptyUser())
        }
    }

    /**
     * Search user by query from Github API
     */
    override fun searchUser(query: String): Flow<List<User>> = flow {
        try {
//            emit(githubApiService.searchUsers(query))
        }catch (e: Exception){
            emit(emptyList())
        }
    }
}