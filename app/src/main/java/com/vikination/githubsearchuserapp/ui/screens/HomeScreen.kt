package com.vikination.githubsearchuserapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vikination.githubsearchuserapp.ui.components.UserList
import com.vikination.githubsearchuserapp.ui.viewmodels.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel = viewModel()){
    val users by viewModel.users.collectAsState()

    Scaffold {
        padding ->
        UserList(modifier = Modifier.padding(padding), users)
    }
}