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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
fun AdminEventsList(
    events: List<Event>,
    modifier: Modifier = Modifier,
    onEventClick: (Int) -> Unit = {},
    onEditClick: (Int) -> Unit = {},
    onAddClick: () -> Unit = {}
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        events.forEach {
            Log.d("eventsList", it.direction)
            Spacer(modifier = Modifier.height(19.dp))
            AdminEventCard(
                event = it,
                modifier = Modifier.fillMaxWidth(),
                onClick = onEventClick,
                editClick = onEditClick
            )
        }

        IconButton(onClick = onAddClick, modifier = Modifier.fillMaxWidth()) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Add event"
            )
        }
    }
}

@Composable
fun AdminEventCard(
    event: Event,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit = {},
    editClick: (Int) -> Unit = {}
) {
    Row(modifier = modifier.clickable { onClick(event.id) }) {
        DirectionImage(
            id = directionIcons[event.direction] ?: R.drawable.sport,
            points = null,
            modifier = Modifier
                .height(87.dp)
                .width(115.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = event.title,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.primary
                )

                IconButton(onClick = { editClick(event.id) }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                }
            }

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

@Preview
@Composable
fun PreviewAdminEvent() {
    AdminEventCard(
        event = Event(
            id = 1,
            title = "Название",
            date = "02.02.22",
            direction = "Спортивное",
            points = null
        )
    )
}