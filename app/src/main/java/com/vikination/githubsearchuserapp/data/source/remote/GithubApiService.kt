package com.vikination.githubsearchuserapp.data.source.remote

import com.vikination.githubsearchuserapp.data.models.GithubUser
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApiService {

    @GET("users")
    suspend fun getUsers(
        @Query("per_page") perPage: Int = 25,
        @Query("page") page: Int = 1
    ): List<GithubUser>

    @GET("users/{username}")
    suspend fun getUserDetail(
        @Path("username") username: String
    ): GithubUser

    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String
    ): List<GithubUser>
}