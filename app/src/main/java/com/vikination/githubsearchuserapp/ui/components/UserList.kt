package com.vikination.githubsearchuserapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vikination.githubsearchuserapp.R
import com.vikination.githubsearchuserapp.data.models.ResultState
import com.vikination.githubsearchuserapp.data.models.User

@Composable
fun UserList(
    onClick : (String) -> Unit,
    modifier: Modifier,
    usersState: ResultState<List<User>>){

    if (usersState is ResultState.Error){
        if (usersState.code == 403){
            Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
                Text(stringResource(R.string.message_error_reach_limit))
            }
        }
    }else{
        LazyColumn(modifier = modifier) {
            if (usersState is ResultState.Loading){
                items(15) {
                    UserItemPlaceholder()
                }
            }else{
                val users = (usersState as ResultState.Success).data
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
}