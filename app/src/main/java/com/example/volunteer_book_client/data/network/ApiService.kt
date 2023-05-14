package com.example.volunteer_book_client.data.network

import com.example.volunteer_book_client.data.User
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.headers

//class ApiService(
//    private val baseUrl: String,
//    private val client: HttpClient
//) {
//    suspend fun checkUser(email: String, password: String): Boolean {
//        val response = client.get {
//            url("$baseUrl/check-user")
//            parameter("email", email)
//            parameter("password", password)
//        }
//
//        return response.status == HttpStatusCode.OK
//    }
//
//    suspend fun getProfile(): User? {
//        val response = client.get<HttpResponse>("$baseUrl/profile") {
//            headers {
//                append()
//            }
//        }
//    }
//}

