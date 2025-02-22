package com.vikination.githubsearchuserapp.data.repository

import com.vikination.githubsearchuserapp.data.models.ResultState
import com.vikination.githubsearchuserapp.data.models.User
import com.vikination.githubsearchuserapp.data.source.remote.GithubApiService
import com.vikination.githubsearchuserapp.domain.repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor (private val githubApiService: GithubApiService) :GithubRepository {

    /**
     * Get users from Github API
     */
    override fun getUsers(): Flow<ResultState<List<User>>> = flow {
        try {
            val response = githubApiService.getUsers()
            if (response.isSuccessful){
                val users = response.body()?.map { it.toUser() } ?: emptyList()
                emit(ResultState.Success(users))
            }else{
                emit(ResultState.Error(response.code(), response.message()))
            }
        }catch (e: Exception){
            e.printStackTrace()
            emit(ResultState.Error(e.hashCode(), e.message ?: "Something went wrong"))
        }
    }.flowOn(Dispatchers.IO)

    /**
     * Get user detail from Github API
     */
    override fun getUserDetail(username: String): Flow<ResultState<User>> = flow {
        try {
            val response = githubApiService.getUserDetail(username)
            if (response.isSuccessful){
                val user = response.body()?.toUser() ?: User.getEmptyUser()
                emit(ResultState.Success(user))
            }else{
                emit(ResultState.Error(response.code(), response.message()))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ResultState.Error(e.hashCode(), e.message ?: "Something went wrong"))
        }
    }.flowOn(Dispatchers.IO)

    /**
     * Search user by query from Github API
     */
    override fun searchUser(query: String): Flow<ResultState<List<User>>> = flow {
        try {
            val response = githubApiService.searchUsers(query)
            if (response.isSuccessful){
                val users = response.body()?.items?.map { it.toUser() } ?: emptyList()
                emit(ResultState.Success(users))
            }else{
                emit(ResultState.Error(response.code(), response.message()))
            }
        }catch (e: Exception){
            emit(ResultState.Error(e.hashCode(), e.message ?: "Something went wrong"))
        }
    }.flowOn(Dispatchers.IO)
}