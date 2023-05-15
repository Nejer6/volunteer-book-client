package com.example.volunteer_book_client.ui.events

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.volunteer_book_client.VolunteerViewModel
import com.example.volunteer_book_client.data.Event
import com.example.volunteer_book_client.ui.components.AdminEventsList

@Composable
fun EventsRoute(
    viewModel: VolunteerViewModel,
    onProfileClick: () -> Unit,
    onEventClick: (Int) -> Unit,
    onAddClick: () -> Unit,
    onEditClick: (Int) -> Unit
) {
    EventsScreen(
        events = viewModel.events,
        content = {
            if (viewModel.profile!!.role == "admin") {
                var adminEvents by remember {
                    mutableStateOf(listOf<Event>())
                }

                LaunchedEffect(true) {
                    adminEvents = viewModel.getAdminEvents()
                }

                AdminEventsList(
                    events = adminEvents,
                    onEditClick = onEditClick,
                    onAddClick = onAddClick
                )
            }
        },
        onProfileClick = onProfileClick,
        onEventClick = onEventClick
    )
}