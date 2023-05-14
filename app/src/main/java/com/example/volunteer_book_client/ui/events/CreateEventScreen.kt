package com.example.volunteer_book_client.ui.events

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
import com.example.volunteer_book_client.ui.components.DoubleButtons

@Composable
fun CreateEventScreen() {
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

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(19.dp)
                .weight(1f)
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }

            Text(text = "Название:")
            TextField(value = title, onValueChange = {
                title = it
            }, modifier = Modifier.fillMaxWidth())
            Text(text = "Адрес:")
            TextField(value = address, onValueChange = {
                address = it
            }, modifier = Modifier.fillMaxWidth())
            Text(text = "Дата:")
            TextField(value = date, onValueChange = {
                date = it
            }, modifier = Modifier.fillMaxWidth())
            Text(text = "Направление:")
            TextField(value = direction, onValueChange = {
                direction = it
            }, modifier = Modifier.fillMaxWidth())
            Text(text = "Организатор:")
            TextField(value = organizer, onValueChange = {
                organizer = it
            }, modifier = Modifier.fillMaxWidth())
            Text(text = "Описание:")
            TextField(
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
            onLeftButtonClick = { /*todo*/ },
            onRightButtonClick = {/*todo*/ },
            leftButtonContent = {
                Text(text = "Удалить", textAlign = TextAlign.Center)
            },
            rightButtonContent = {
                Text(text = "Создать", textAlign = TextAlign.Center)
            }
        )
    }
}