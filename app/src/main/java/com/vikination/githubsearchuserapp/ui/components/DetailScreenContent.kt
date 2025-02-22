package com.vikination.githubsearchuserapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.vikination.githubsearchuserapp.R
import com.vikination.githubsearchuserapp.data.models.ResultState
import com.vikination.githubsearchuserapp.data.models.User
import com.vikination.githubsearchuserapp.ui.theme.quicksandFamily

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreenContent(
    modifier: Modifier,
    userState: ResultState<User>,
    textColor : Color = Color.Black
){
    if (userState is ResultState.Error){
        if (userState.code == 403){
            Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
                Text("You have reach limit to request Github API")
            }
        }
    }else{
        if (userState is ResultState.Loading){
            Box(modifier = Modifier.fillMaxSize()){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }else{
            val user = (userState as ResultState.Success).data
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
    }
}

@Preview
@Composable
fun DetailScreenContentPreview(){
    DetailScreenContent(
        Modifier.padding(8.dp),
        ResultState.Success(User.getDummyUser())
    )
}

@Preview
@Composable
fun DetailScreenContentPreviewLoading(){
    DetailScreenContent(
        Modifier.padding(8.dp),
        ResultState.Loading
    )
}

@Preview
@Composable
fun DetailScreenContentPreviewError(){
    DetailScreenContent(
        Modifier.padding(8.dp),
        ResultState.Error(403, stringResource(R.string.message_error_reach_limit))
    )
}