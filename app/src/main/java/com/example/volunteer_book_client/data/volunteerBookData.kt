package com.example.volunteer_book_client.data

import com.example.volunteer_book_client.R
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val role: String,
    val avatarUrl: String,
    val name: String,
    val surname: String,
    val city: String,
    val birthday: String,
    val phone: String,
    val email: String,
    val organization: String,
    val points: Int,
    val currentEvents: List<Event>,
    val previousEvents: List<Event>
)

@Serializable
data class Event(
    val id: Int,
    val title: String,
    val date: String,
    val direction: String,
    val points: Int?
)

@Serializable
data class EventDetail(
    val id: Int,
    val title: String,
    val date: String,
    val direction: String,
    val address: String,
    val organizer: String,
    val description: String,
    val state: String
)

val directionIcons = hashMapOf(
    "Спортивное" to R.drawable.sport,
    "Патриотическое" to R.drawable.patriotic,
    "Духовно-нравственное" to R.drawable.moral,
    "Социальное" to R.drawable.social,
    "Культурное" to R.drawable.culture
)
