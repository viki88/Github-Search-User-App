package com.vikination.githubsearchuserapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun UserItemPlaceholder(){
    Card(
        modifier = Modifier.padding(4.dp).fillMaxWidth().shimmer()) {
        Row(
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(45.dp).clip(CircleShape).background(Color.Gray)
            )
            Box(
                modifier = Modifier.height(21.dp).padding(8.dp,0.dp,0.dp,0.dp).fillMaxWidth().background(Color.Gray)
            )
        }
    }
}