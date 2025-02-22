package com.vikination.githubsearchuserapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vikination.githubsearchuserapp.ui.screens.DetailScreen
import com.vikination.githubsearchuserapp.ui.screens.HomeScreen
import com.vikination.githubsearchuserapp.ui.screens.Screen
import com.vikination.githubsearchuserapp.ui.theme.GithubSearchUserAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GithubSearchUserAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Home.route) {
                    composable(Screen.Home.route) {
                        HomeScreen(navController)
                    }
                    composable(Screen.Detail.route) {
                        backStackEntry ->
                        val username = backStackEntry.arguments?.getString("username")?:return@composable
                        DetailScreen(username, navController)
                    }
                }
            }
        }
    }
}