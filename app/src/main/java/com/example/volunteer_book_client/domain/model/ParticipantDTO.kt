package com.example.volunteer_book_client.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ParticipantDTO(
    val id: Int,
    val name: String,
    val surname: String,
    val points: Int?
)
