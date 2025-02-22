package com.vikination.githubsearchuserapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vikination.githubsearchuserapp.ui.components.DetailScreenContent
import com.vikination.githubsearchuserapp.ui.viewmodels.MainViewModel

@Composable
fun DetailScreen(
    username :String,
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()){
    val userState by viewModel.userState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getUserDetail(username)
    }

    Scaffold(contentColor = Color.Black) {
        innerPadding ->
        DetailScreenContent(
            Modifier.padding(paddingValues = innerPadding).fillMaxHeight(),
            userState
        )
    }
}

@Preview
@Composable
fun DetailScreenPreview(){
    DetailScreen(
        "vikination",
        navController = rememberNavController(),
        viewModel = hiltViewModel()
    )
}