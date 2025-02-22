package com.vikination.githubsearchuserapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vikination.githubsearchuserapp.data.models.User
import com.vikination.githubsearchuserapp.domain.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: GithubRepository) : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _user = MutableStateFlow(User.getEmptyUser())
    val user: StateFlow<User> = _user

    fun loadAllUsers() {
        viewModelScope.launch {
            repository.getUsers().collect {
                _users.value = it
            }
        }
    }

    fun getUserDetail(username: String){
        viewModelScope.launch {
            repository.getUserDetail(username).collect{
                _user.value = it
            }
        }
    }

}