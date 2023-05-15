package com.example.volunteer_book_client.ui.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.volunteer_book_client.R
import com.example.volunteer_book_client.data.directionIcons
import com.example.volunteer_book_client.domain.model.EventEditDTO
import com.example.volunteer_book_client.ui.components.Characteristics
import com.example.volunteer_book_client.ui.components.DirectionImage
import kotlin.math.sin

@Composable
fun EventEditScreen(
    eventEditDTO: EventEditDTO,
    acceptRequest: (eventId: Int, userId: Int) -> Unit = { _, _ -> },
    declineRequest: (eventId: Int, userId: Int) -> Unit = { _, _ -> },
    deleteParticipant: (eventId: Int, userId: Int) -> Unit = { _, _ -> },
    updatePoints: (eventId: Int, userId: Int, points: Int?) -> Unit = { _, _, _ -> },
    onRequestClick: (userId: Int) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(19.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DirectionImage(
            id = directionIcons[eventEditDTO.direction] ?: R.drawable.sport,
            modifier = Modifier.fillMaxWidth(0.7f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = eventEditDTO.title,
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h5.fontSize
        )

        Spacer(modifier = Modifier.height(12.dp))

        Characteristics(
            titleAndValueList = listOf(
                "Адрес:" to eventEditDTO.address,
                "Дата:" to eventEditDTO.date,
                "Направление:" to eventEditDTO.direction,
                "Организатор:" to eventEditDTO.organizer,
                "Описание:" to ""
            ), modifier = Modifier.fillMaxWidth(),
            spacerDp = 10.dp
        )

        Text(text = eventEditDTO.description, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Заявки", color = MaterialTheme.colors.primary)

        Column(modifier = Modifier.fillMaxWidth()) {
            eventEditDTO.requests.forEach {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onRequestClick(it.id) },
                    verticalAlignment = CenterVertically
                ) {
                    Text(text = "${it.name} ${it.surname}", modifier = Modifier.weight(1f))

                    IconButton(onClick = { acceptRequest(eventEditDTO.id, it.id) }) {
                        Icon(Icons.Default.Check, contentDescription = "Accept")
                    }

                    IconButton(onClick = { declineRequest(eventEditDTO.id, it.id) }) {
                        Icon(Icons.Default.Close, contentDescription = "Decline")
                    }

                }
            }
        }

        Text(text = "Участники", color = MaterialTheme.colors.primary)

        Column(modifier = Modifier.fillMaxWidth()) {
            eventEditDTO.participants.forEach {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = CenterVertically) {
                    Text(text = "${it.name} ${it.surname}", modifier = Modifier.weight(1f))

                    Row {
                        var points by remember {
                            mutableStateOf(if (it.points == null) "" else it.points.toString())
                        }

                        OutlinedTextField(value = points, onValueChange = { str ->
                            updatePoints(eventEditDTO.id, it.id, str.toIntOrNull())
                            points = str
                        }, modifier = Modifier.width(64.dp), placeholder = {
                            Text(text = "100")
                        }, singleLine = true)
                    }

                    IconButton(onClick = { deleteParticipant(eventEditDTO.id, it.id) }) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete participant")
                    }
                }
            }
        }

    }
}