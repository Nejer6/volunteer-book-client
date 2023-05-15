package com.example.volunteer_book_client.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class EventCreateDTO(
    val title: String,
    val date: String,
    val direction: String,
    val address: String,
    val organizer: String,
    val description: String
)
