package com.example.volunteer_book_client.ui.events

import androidx.compose.runtime.Composable
import com.example.volunteer_book_client.VolunteerViewModel

@Composable
fun EventDetailRoute(
    viewModel: VolunteerViewModel,
    onSubmit: (Int) -> Unit
) {
    EventDetailScreen(eventDetail = viewModel.currentEventDetail!!, onSubmit = onSubmit)
}