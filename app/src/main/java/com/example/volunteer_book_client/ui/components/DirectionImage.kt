package com.example.volunteer_book_client.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.volunteer_book_client.R

@Composable
fun DirectionImage(id: Int, modifier: Modifier = Modifier, points: Int? = null) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colors.surface),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(
                id = id
            ),
            contentDescription = "Direction Image",
            modifier = Modifier.fillMaxSize()
        )
        if (points != null) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .align(Alignment.BottomEnd)
                    .offset(10.dp, 10.dp)
                    .clip(RoundedCornerShape(19.dp))
                    .background(MaterialTheme.colors.background)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Points",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset((-8).dp, 2.dp)
                )
                Text(
                    text = points.toString(),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .offset(3.dp, 0.dp)
                )
            }
        }
    }
}