package com.vikination.githubsearchuserapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.vikination.githubsearchuserapp.data.models.ResultState
import com.vikination.githubsearchuserapp.ui.components.SearchAppBar
import com.vikination.githubsearchuserapp.ui.components.UserList
import com.vikination.githubsearchuserapp.ui.viewmodels.MainViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel<MainViewModel>()
){
    val usersState by viewModel.usersState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    LaunchedEffect(Unit) {
//        viewModel.loadAllUsers()
    }

    Scaffold(
        topBar = {
            SearchAppBar(
                searchQuery,
                onSearchQueryChanged = {viewModel.updateQuery(it)},
                onSearchClicked = {viewModel.fetchUserSearch()},
                onClose = {viewModel.updateQuery("")}
            )
        }
    ) {
        padding ->
        UserList(
            modifier = Modifier.padding(padding),
            onClick = {
                username ->
                    navController.navigate(Screen.Detail.createRoute(username))
            },
            usersState = usersState
        )
    }
}