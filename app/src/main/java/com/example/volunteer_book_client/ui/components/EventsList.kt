package com.example.volunteer_book_client.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.volunteer_book_client.R
import com.example.volunteer_book_client.data.Event
import com.example.volunteer_book_client.data.directionIcons

@Composable
fun EventsList(
    events: List<Event>,
    modifier: Modifier = Modifier,
    onEventClick: (Int) -> Unit = {}
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        events.forEach {
            Log.d("eventsList", it.direction)
            Spacer(modifier = Modifier.height(19.dp))
            EventCard(event = it, modifier = Modifier.fillMaxWidth(), onClick = onEventClick)
        }
    }
}

@Composable
fun EventCard(event: Event, modifier: Modifier = Modifier, onClick: (Int) -> Unit = {}) {
    Row(modifier = modifier.clickable { onClick(event.id) }) {
        DirectionImage(
            id = directionIcons[event.direction] ?: R.drawable.sport,
            points = event.points,
            modifier = Modifier
                .height(87.dp)
                .width(115.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = event.title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.primary
            )
            Row(modifier = Modifier.fillMaxSize()) {
                Column(verticalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Дата:")
                    Text(text = event.date)
                }
                Spacer(modifier = Modifier.width(5.dp))
                Column(verticalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Направление:")
                    Text(text = event.direction)
                }
            }
        }
    }
}