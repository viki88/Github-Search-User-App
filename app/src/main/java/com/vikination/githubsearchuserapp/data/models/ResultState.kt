package com.vikination.githubsearchuserapp.data.models

sealed class ResultState<out T>{
    data object Loading : ResultState<Nothing>()
    data class Success<out T>(val data : T) : ResultState<T>()
    data class Error(val code :Int, val message : String) : ResultState<Nothing>()
}