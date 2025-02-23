package com.vikination.githubsearchuserapp.data.repository

import android.util.Log
import com.vikination.githubsearchuserapp.data.models.ResultState
import com.vikination.githubsearchuserapp.data.models.User
import com.vikination.githubsearchuserapp.data.source.local.dao.UserDao
import com.vikination.githubsearchuserapp.data.source.remote.GithubApiService
import com.vikination.githubsearchuserapp.data.source.remote.utils.NetworkUtils
import com.vikination.githubsearchuserapp.domain.repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import retrofit2.Response
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor (
    private val githubApiService: GithubApiService,
    private val userDao: UserDao,
    private val networkUtils: NetworkUtils
) :GithubRepository {

    /**
     * Get all users from database
     */
    override fun getCachedUsers(): Flow<List<User>> =
        userDao.getAllLocalUsers().map { users -> users.map { it.toUser() }}

    /**
     * Get user detail from Github API
     */
    override fun getUserDetail(username: String): Flow<ResultState<User>> = flow {
        emit(ResultState.Loading)

        val cachedUser = userDao.getUserDetail(username).firstOrNull()
        Log.i("TAG", "getUserDetail cached: $cachedUser")
        if (cachedUser != null){
            emit(ResultState.Success(cachedUser.toUser()))
        }

        if (networkUtils.isInternetAvailable()){
            try {
                val response = githubApiService.getUserDetail(username)
                if (response.isSuccessful){
                    val user = response.body()?.toUser() ?: User.getEmptyUser()

                    userDao.updateUser(user.toUserEntity())

                    emit(ResultState.Success(user))
                }else{
                    emit(ResultState.Error(response.code(), response.message()))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ResultState.Error(e.hashCode(), e.message ?: "Something went wrong"))
            }
        }
    }.flowOn(Dispatchers.IO)

    /**
     * Search user by query from Github API
     */
    override fun searchUser(query: String): Flow<ResultState<List<User>>> = flow {
        emit(ResultState.Loading)

        if (networkUtils.isInternetAvailable()){
            try {
                val response = githubApiService.searchUsers(query)
                if (response.isSuccessful){
                    val users = response.body()?.items?.map { it.toUser() } ?: emptyList()

                    userDao.clearUsers()
                    userDao.insertUsers(users.map { it.toUserEntity() })

                    emit(ResultState.Success(users))
                }else{
                    emit(ResultState.Error(response.code(), response.message()))
                }
            }catch (e: Exception){
                emit(ResultState.Error(e.hashCode(), e.message ?: "Something went wrong"))
            }
        }else{
            emit(ResultState.Success(userDao.searchUsers(query).firstOrNull()?.map { it.toUser() } ?: emptyList()))
        }
    }.flowOn(Dispatchers.IO)
}