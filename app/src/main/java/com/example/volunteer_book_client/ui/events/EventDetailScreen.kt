package com.example.volunteer_book_client.ui.events

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.volunteer_book_client.R
import com.example.volunteer_book_client.data.EventDetail
import com.example.volunteer_book_client.data.directionIcons
import com.example.volunteer_book_client.ui.components.Characteristics
import com.example.volunteer_book_client.ui.components.DirectionImage
import com.example.volunteer_book_client.utils.isFutureDate

@Composable
fun EventDetailScreen(
    eventDetail: EventDetail,
    onSubmit: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(19.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DirectionImage(
            id = directionIcons[eventDetail.direction] ?: R.drawable.sport,
            modifier = Modifier.fillMaxWidth(0.7f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = eventDetail.title,
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h5.fontSize
        )

        Spacer(modifier = Modifier.height(12.dp))

        Characteristics(
            titleAndValueList = listOf(
                "Адрес:" to eventDetail.address,
                "Дата:" to eventDetail.date,
                "Направление:" to eventDetail.direction,
                "Организатор:" to eventDetail.organizer,
                "Описание:" to ""
            ), modifier = Modifier.fillMaxWidth(),
            spacerDp = 10.dp
        )

        Text(text = eventDetail.description, modifier = Modifier.fillMaxWidth())

        if (isFutureDate(eventDetail.date)) {
            var enabled = false
            var text = ""

            when (eventDetail.state) {
                "Not submitted" -> {
                    enabled = true
                    text = "Записаться на мероприятие"
                }

                "Under review" -> text = "Заявка на рассмотрении"

                "Accepted" -> text = "Ваша заявка принята"

                "Declined" -> text = "Извините, но вы не можете участвовать в этом мероприятии("

                "Created" -> text = "Создано"
            }

            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = { onSubmit(eventDetail.id) }, enabled = enabled) {
                    Text(text = text)
                }
            }

        }
    }
}