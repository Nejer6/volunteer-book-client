package com.example.volunteer_book_client.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min

@Composable
fun PointsBarForVolunteer(points: Int, modifier: Modifier = Modifier) {
    var minValue = 0
    var maxValue = Int.MAX_VALUE

    when(points) {
        in 0 until 200 -> {
            minValue = 0
            maxValue = 200
        }

        in 200 until 400 -> {
            minValue = 200
            maxValue = 400
        }

        in 400 until 600 -> {
            minValue = 400
            maxValue = 600
        }

        in 600 until 800 -> {
            minValue = 600
            maxValue = 800
        }

        in 800 until 1000 -> {
            minValue = 800
            maxValue = 1000
        }

        else -> {
            minValue = 1000
            maxValue = points
        }
    }

    PointsBar(minValue = minValue, maxValue = maxValue, currentValue = points, modifier = modifier)
}

@Composable
fun PointsBar(minValue: Int, maxValue: Int, currentValue: Int, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = currentValue.toString())
            Text(text = maxValue.toString())
        }
        Spacer(modifier = Modifier.height(10.dp))
        LinearProgressIndicator(
            progress = (currentValue - minValue).toFloat() / (maxValue - minValue),
            modifier = Modifier
                .fillMaxWidth()
                .height(11.dp)
                .clip(RoundedCornerShape(11.dp))
        )
    }
}