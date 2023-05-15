package com.example.volunteer_book_client

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.volunteer_book_client.data.Event
import com.example.volunteer_book_client.data.EventDetail
import com.example.volunteer_book_client.data.User
import com.example.volunteer_book_client.data.repository.EventRepository
import com.example.volunteer_book_client.data.repository.UserRepository
import com.example.volunteer_book_client.domain.model.EventCreateDTO
import com.example.volunteer_book_client.domain.model.EventEditDTO
import com.example.volunteer_book_client.domain.model.ParticipantDTO

class VolunteerViewModel(
    private val userRepository: UserRepository,
    private val eventRepository: EventRepository
) : ViewModel() {
    var profile: User? = null
    var currentEventDetail by mutableStateOf<EventDetail?>(null)
    var currentEventEdit by mutableStateOf<EventEditDTO?>(null)
    var events: List<Event> = listOf()

    suspend fun getSelfProfile(username: String, password: String) {
        userRepository.changeCredentials(username, password)
        profile = userRepository.getSelfProfile()
    }

    suspend fun getEventDetailById(eventId: Int) {
        currentEventDetail = eventRepository.getEventDetailById(eventId)
    }

    suspend fun getEvents() {
        events = eventRepository.getEvents()
    }

    suspend fun postRequest(eventId: Int) {
        eventRepository.postRequest(eventId)
        currentEventDetail = currentEventDetail?.copy(state = "Under review")
    }

    suspend fun getAdminEvents(): List<Event> {
        return eventRepository.getAdminEvents()
    }

    suspend fun createEvent(eventCreateDTO: EventCreateDTO) {
        eventRepository.createEvent(eventCreateDTO)
    }

    suspend fun getEventEdit(eventId: Int) {
        currentEventEdit = eventRepository.getEventEdit(eventId = eventId)
    }

    suspend fun acceptRequest(eventId: Int, userId: Int) {
        eventRepository.acceptRequest(eventId, userId)
        val request = currentEventEdit?.requests?.find { it.id == userId }!!
        currentEventEdit =
            currentEventEdit?.copy(
                requests = currentEventEdit?.requests?.filter { it.id != userId }
                ?: listOf(),
                participants = currentEventEdit?.participants?.toMutableList()?.plus(ParticipantDTO(
                    id = request.id,
                    name = request.name,
                    surname = request.surname,
                    points = null
                ))!!
            )
    }

    suspend fun declineRequest(eventId: Int, userId: Int) {
        eventRepository.declineRequest(eventId, userId)
        currentEventEdit =
            currentEventEdit?.copy(
                requests = currentEventEdit?.requests?.filter { it.id != userId }
                    ?: listOf()
            )
    }

    suspend fun updatePoints(eventId: Int, userId: Int, points: Int?) {
        eventRepository.updatePoints(eventId, userId, points)
    }

    suspend fun deleteParticipant(eventId: Int, userId: Int) {
        eventRepository.deleteParticipant(eventId, userId)
        currentEventEdit =
            currentEventEdit?.copy(
                participants = currentEventEdit?.participants?.filter { it.id != userId }
                    ?: listOf()
            )
    }

    suspend fun checkUser(email: String, password: String): Boolean {
        return userRepository.checkUser(email, password)
    }

    fun submitForEvent() {
        //todo
    }
}