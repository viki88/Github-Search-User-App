package com.vikination.githubsearchuserapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vikination.githubsearchuserapp.data.models.ResultState
import com.vikination.githubsearchuserapp.data.models.User
import com.vikination.githubsearchuserapp.domain.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: GithubRepository) : ViewModel() {
    private val _usersState = MutableStateFlow<ResultState<List<User>>>(ResultState.Loading)
    val usersState: StateFlow<ResultState<List<User>>> = _usersState

    private val _userState = MutableStateFlow<ResultState<User>>(ResultState.Loading)
    val userState: StateFlow<ResultState<User>> = _userState

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    fun updateQuery(keyword :String){
        _searchQuery.value = keyword
    }

    fun fetchUserSearch(){
        val keyword = _searchQuery.value.trim()
        if (keyword.isEmpty())return

        viewModelScope.launch {
            repository.searchUser(keyword).collect{
                _usersState.value = it
            }
        }
    }

    fun loadAllUsers() {
        viewModelScope.launch {
            repository.getCachedUsers().collect {
                _usersState.value = ResultState.Success(it)
            }
        }
    }

    fun getUserDetail(username: String){
        viewModelScope.launch {
            repository.getUserDetail(username).collect{
                _userState.value = it
            }
        }
    }

}