package com.example.volunteer_book_client

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.volunteer_book_client.data.Event
import com.example.volunteer_book_client.data.EventDetail
import com.example.volunteer_book_client.data.User
import com.example.volunteer_book_client.data.UserData
import com.example.volunteer_book_client.data.repository.EventRepository
import com.example.volunteer_book_client.data.repository.UserRepository

class VolunteerViewModel(
    private val userRepository: UserRepository,
    private val eventRepository: EventRepository
    ) : ViewModel() {
    var profile: User? = null
    var currentEventDetail by mutableStateOf<EventDetail?>(null)
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

    suspend fun checkUser(email: String, password: String): Boolean {
        return userRepository.checkUser(email, password)
    }

    fun login(login: String, password: String) {
        //todo
        if (login == "" && password == "") {
            profile = UserData.currentUser
        }
    }

    fun submitForEvent() {
        //todo
    }
}