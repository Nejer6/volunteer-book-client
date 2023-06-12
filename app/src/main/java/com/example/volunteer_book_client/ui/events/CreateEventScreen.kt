package com.example.volunteer_book_client.ui.events

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.volunteer_book_client.domain.model.EventCreateDTO
import com.example.volunteer_book_client.ui.components.DoubleButtons

@Composable
fun CreateEventScreen(onSend: (EventCreateDTO) -> Unit = {}, onUndo: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        var title by remember {
            mutableStateOf("")
        }
        var address by remember {
            mutableStateOf("")
        }
        var date by remember {
            mutableStateOf("")
        }
        var direction by remember {
            mutableStateOf("")
        }
        var organizer by remember {
            mutableStateOf("")
        }
        var description by remember {
            mutableStateOf("")
        }

        var maxParticipant by remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(19.dp)
                .weight(1f)
        ) {
            IconButton(onClick = onUndo) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }

            Text(text = "Название:")
            OutlinedTextField(value = title, onValueChange = {
                title = it
            }, modifier = Modifier.fillMaxWidth())
            Text(text = "Адрес:")
            OutlinedTextField(value = address, onValueChange = {
                address = it
            }, modifier = Modifier.fillMaxWidth())
            Text(text = "Дата:")
            OutlinedTextField(value = date, onValueChange = {
                date = it
            }, modifier = Modifier.fillMaxWidth())
            Text(text = "Направление:")
            OutlinedTextField(value = direction, onValueChange = {
                direction = it
            }, modifier = Modifier.fillMaxWidth())
            Text(text = "Организатор:")
            OutlinedTextField(value = organizer, onValueChange = {
                organizer = it
            }, modifier = Modifier.fillMaxWidth())
            Text(text = "Максимальное число участников(не обязательно):")
            OutlinedTextField(value = maxParticipant, onValueChange = {
                maxParticipant = it
            }, modifier = Modifier.fillMaxWidth())
            Text(text = "Описание:")
            OutlinedTextField(
                value = description, onValueChange = {
                    description = it
                }, modifier = Modifier
                    .fillMaxSize()
            )
        }

        DoubleButtons(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            state = false,
            onLeftButtonClick = onUndo,
            onRightButtonClick = {
                onSend(
                    EventCreateDTO(
                        title = title,
                        address = address,
                        date = date,
                        direction = direction,
                        description = description,
                        organizer = organizer,
                        maxParticipant = maxParticipant.toIntOrNull()
                    )
                )
            },
            leftButtonContent = {
                Text(text = "Удалить", textAlign = TextAlign.Center)
            },
            rightButtonContent = {
                Text(text = "Создать", textAlign = TextAlign.Center)
            }
        )
    }
}