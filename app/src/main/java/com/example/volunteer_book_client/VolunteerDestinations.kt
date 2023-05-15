package com.example.volunteer_book_client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

interface VolunteerDestination {
    val route: String
}

object Profile : VolunteerDestination {
    val icon = Icons.Filled.Person
    override val route = "profile"
}

object Events : VolunteerDestination {
    val icon = Icons.Filled.DateRange
    override val route = "events"
}

object Authorization : VolunteerDestination {
    override val route = "authorization"
}

object CreateEvent : VolunteerDestination {
    override val route = "create-event"
}

object EventDetail : VolunteerDestination {
    override val route = "event-detail"
}

object EventEdit : VolunteerDestination {
    override val route = "event-edit"
}