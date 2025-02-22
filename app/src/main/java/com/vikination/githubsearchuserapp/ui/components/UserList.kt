package com.vikination.githubsearchuserapp.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vikination.githubsearchuserapp.data.models.User

@Composable
fun UserList(
    onClick : (String) -> Unit,
    modifier: Modifier, users: List<User>){
    LazyColumn(modifier = modifier) {
        if (users.isEmpty()){
            items(15) {
                UserItemPlaceholder()
            }
        }else{
            items(users.size) { index ->
                val user = users[index]
                UserItem(
                    user = user,
                    onClick = {
                        onClick(user.username)
                    }
                )
            }
        }
    }
}