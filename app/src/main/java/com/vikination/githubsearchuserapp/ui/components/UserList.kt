package com.vikination.githubsearchuserapp.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vikination.githubsearchuserapp.data.models.User

@Composable
fun UserList(modifier: Modifier, users: List<User>){
    LazyColumn(modifier = modifier) {
        items(users.size) { index ->
            UserItem(user = users[index])
        }

    }
}