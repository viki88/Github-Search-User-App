package com.vikination.githubsearchuserapp.data.models

import com.squareup.moshi.Json


data class SearchUserResponse(
    @Json(name = "total_count") val totalCount :Int,
    @Json(name = "incomplete_results") val incompleteResults :Boolean,
    @Json(name = "items") val items :List<GithubUser>
)