package com.vikination.githubsearchuserapp.data.source.remote

import com.vikination.githubsearchuserapp.data.models.GithubUser
import com.vikination.githubsearchuserapp.data.models.SearchUserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApiService {

    @GET("users/{username}")
    suspend fun getUserDetail(
        @Path("username") username: String
    ): Response<GithubUser>

    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String
    ): Response<SearchUserResponse>
}