package com.example.volunteer_book_client.ui.events

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.volunteer_book_client.data.Event
import com.example.volunteer_book_client.ui.components.DoubleButtons
import com.example.volunteer_book_client.ui.components.EventsList

@Composable
fun EventsScreen(
    events: List<Event>,
    onProfileClick: () -> Unit = {},
    onEventClick: (Int) -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(19.dp)
            .weight(1f)
        ) {
            content()

            EventsList(
                events = events,
                modifier = Modifier
                    .fillMaxWidth(),
                onEventClick = onEventClick
            )
        }

        DoubleButtons(
            state = false,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            leftButtonContent = {
                Icon(Icons.Default.Person, contentDescription = "Profile")
            },
            rightButtonContent = {
                Icon(Icons.Default.DateRange, contentDescription = "Events")
            },
            onLeftButtonClick = onProfileClick,
            onRightButtonClick = { }
        )
    }
}