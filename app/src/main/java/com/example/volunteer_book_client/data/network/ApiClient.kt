package com.example.volunteer_book_client.data.network

import com.example.volunteer_book_client.data.Event
import com.example.volunteer_book_client.data.EventDetail
import com.example.volunteer_book_client.data.User
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BasicAuthCredentials
import io.ktor.client.plugins.auth.providers.basic
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.plugin
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json

class ApiClient(private val baseUrl: String) {
    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json()
        }
        install(Auth) {
            basic {
                credentials {
                    BasicAuthCredentials("", "")
                }
            }
        }
    }

    fun changeCredentials(username: String, password: String) {
        client.plugin(Auth).basic {
            credentials {
                BasicAuthCredentials(username, password)
            }
        }
    }

    //todo
    suspend fun checkUser(email: String, password: String): Boolean {
        val response = client.get {
            url("$baseUrl/check-user")
            parameter("email", email)
            parameter("password", password)
        }

        return response.status == HttpStatusCode.OK
    }

    suspend fun getProfile(): User? {
        return try {
            client.get("$baseUrl/api/protected/profile").body()
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getEventDetailById(eventId: Int): EventDetail? {
        return try {
            client.get("$baseUrl/api/protected/events/$eventId").body()
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getEvents(): List<Event> {
        return try {
            client.get("$baseUrl/api/protected/events").body()
        } catch (e: Exception) {
            listOf()
        }
    }

    suspend fun postRequest(eventId: Int) {
        client.post("$baseUrl/api/protected/events/$eventId/send-request")
    }
}