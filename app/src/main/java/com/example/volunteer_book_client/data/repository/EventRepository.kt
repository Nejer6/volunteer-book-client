package com.example.volunteer_book_client.data.repository

import com.example.volunteer_book_client.data.Event
import com.example.volunteer_book_client.data.EventDetail
import com.example.volunteer_book_client.data.network.ApiClient

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
}