package com.example.volunteer_book_client.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun isFutureDate(dataString: String) : Boolean {
    val format = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
    val date = format.parse(dataString)
    val now = Date()
    return date.after(now)
}