package com.example.volunteer_book_client.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.volunteer_book_client.data.User
import com.example.volunteer_book_client.ui.components.Characteristics
import com.example.volunteer_book_client.ui.components.EventsList
import com.example.volunteer_book_client.ui.components.PointsBarForVolunteer

@Composable
fun ParticipantProfileScreen(
    user: User?,
    onEventClick: (Int) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (user == null) {
            Text(text = "Loading", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(19.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(11.dp))
                AsyncImage(
                    model = user.avatarUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .clip(RoundedCornerShape(50.dp))
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "${user.name} ${user.surname}", fontSize = 24.sp)
                Spacer(modifier = Modifier.height(10.dp))

                PointsBarForVolunteer(points = user.points, modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(20.dp))

                Characteristics(
                    titleAndValueList = listOf(
                        "Город:" to user.city,
                        "Дата рождения:" to user.birthday,
                        "Телефон:" to user.phone,
                        "Почта:" to user.email,
                        "Организация:" to user.organization
                    ), modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(text = "Прошедшие мероприятия:", color = MaterialTheme.colors.primary)

                EventsList(
                    events = user.previousEvents,
                    modifier = Modifier.fillMaxWidth(),
                    onEventClick = onEventClick
                )

            }
        }
    }
}