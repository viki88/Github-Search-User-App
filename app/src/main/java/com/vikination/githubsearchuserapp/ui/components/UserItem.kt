package com.vikination.githubsearchuserapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.vikination.githubsearchuserapp.data.models.User

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserItem (user: User){
    Card(
        modifier = Modifier.padding(4.dp).fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                modifier = Modifier.size(45.dp).clip(CircleShape),
                model = user.avatarUrl,
                contentDescription = user.username
            )
            Text(modifier = Modifier.padding(start = 8.dp), text = user.username)
        }
    }

}