package com.vikination.githubsearchuserapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.vikination.githubsearchuserapp.data.models.User
import com.vikination.githubsearchuserapp.ui.theme.quicksandFamily

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreenContent(
    modifier: Modifier,
    user: User,
    textColor : Color = Color.Black
){
    Column {
        GlideImage(
            modifier = Modifier.height(300.dp).fillMaxSize(),
            model = user.avatarUrl,
            contentDescription = user.username,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(32.dp)) {
            Text(
                color = textColor,
                text = user.name,
                fontSize = 22.sp,
                fontFamily = quicksandFamily,
                fontWeight = FontWeight.Bold
            )
            Text(
                color = textColor,
                text = user.username,
                fontSize = 12.sp,
                fontFamily = quicksandFamily
            )
            Text(
                color = textColor,
                text = user.blog,
                fontSize = 12.sp,
                fontFamily = quicksandFamily
            )
            Text(
                color = textColor,
                text = "Location : ${user.location}",
                fontSize = 12.sp,
                fontFamily = quicksandFamily
            )
            Spacer(Modifier.size(16.dp))
            Text(
                color = textColor,
                text = "Bio",
                fontSize = 12.sp,
                fontFamily = quicksandFamily,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                color = textColor,
                text = user.bio,
                fontSize = 12.sp,
                fontFamily = quicksandFamily
            )
        }
    }
}

@Preview
@Composable
fun DetailScreenContentPreview(){
    DetailScreenContent(Modifier.padding(8.dp), User.getDummyUser())
}