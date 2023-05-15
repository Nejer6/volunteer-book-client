package com.example.volunteer_book_client.data.repository

import com.example.volunteer_book_client.data.Event
import com.example.volunteer_book_client.data.EventDetail
import com.example.volunteer_book_client.data.network.ApiClient
import com.example.volunteer_book_client.domain.model.EventCreateDTO
import com.example.volunteer_book_client.domain.model.EventEditDTO

class EventRepository(
    private val apiClient: ApiClient
) {
    suspend fun getEventDetailById(eventId: Int): EventDetail? {
        return apiClient.getEventDetailById(eventId)
    }

    suspend fun getEvents() : List<Event> {
        return apiClient.getEvents()
    }

    suspend fun postRequest(eventId: Int) {
        apiClient.postRequest(eventId)
    }

    suspend fun getAdminEvents() : List<Event> {
        return apiClient.getAdminEvents()
    }

    suspend fun createEvent(eventCreateDTO: EventCreateDTO) {
        apiClient.postEvent(eventCreateDTO)
    }

    suspend fun getEventEdit(eventId: Int): EventEditDTO? {
        return apiClient.getEventEdit(eventId = eventId)
    }

    suspend fun acceptRequest(eventId: Int, userId: Int) {
        apiClient.acceptRequest(eventId, userId)
    }

    suspend fun declineRequest(eventId: Int, userId: Int) {
        apiClient.declineRequest(eventId, userId)
    }

    suspend fun updatePoints(eventId: Int, userId: Int, points: Int?) {
        apiClient.updatePoints(eventId, userId, points)
    }

    suspend fun deleteParticipant(eventId: Int, userId: Int) {
        apiClient.deleteParticipant(eventId, userId)
    }
}