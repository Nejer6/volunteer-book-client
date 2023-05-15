package com.example.volunteer_book_client.data.repository

import com.example.volunteer_book_client.data.User
import com.example.volunteer_book_client.data.network.ApiClient

class UserRepository(private val apiClient: ApiClient) {
    suspend fun checkUser(email: String, password: String): Boolean {
        return apiClient.checkUser(email, password)
    }

    fun changeCredentials(username: String, password: String) {
        apiClient.changeCredentials(username, password)
    }

    suspend fun getSelfProfile(): User? {
        return apiClient.getProfile()
    }

    suspend fun getUserProfile(userId: Int): User {
        return apiClient.getUserProfile(userId = userId)
    }
}