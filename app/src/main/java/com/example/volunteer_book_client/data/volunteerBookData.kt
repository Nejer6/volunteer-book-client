package com.example.volunteer_book_client.data

import com.example.volunteer_book_client.R
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val avatarUrl: String,
    val name: String,
    val surname: String,
    val city: String,
    val birthday: String,
    val phone: String,
    val email: String,
    val organization: String,
    val points: Int,
    val currentEvents: List<Event>,
    val previousEvents: List<Event>
)

@Serializable
data class Event(
    val id: Int,
    val title: String,
    val date: String,
    val direction: String,
    val points: Int?
)

@Serializable
data class EventDetail(
    val id: Int,
    val title: String,
    val date: String,
    val direction: String,
    val address: String,
    val organizer: String,
    val description: String,
    val state: String
)

val directionIcons = hashMapOf(
    "Спортивное" to R.drawable.sport,
    "Патриотическое" to R.drawable.patriotic,
    "Духовно-нравственное" to R.drawable.moral,
    "Социальное" to R.drawable.social,
    "Культурное" to R.drawable.culture
)

object UserData {
    val eventDetails = listOf(
        EventDetail(
            id = 1,
            title = "Спорт для всех",
            date = "25.06.23",
            direction = "Спортивное",
            address = "г. Пушкино, ул. Колотушкина, д. 2",
            organizer = "Лорд Волдеморт",
            description = "Наше спортивное волонтерское мероприятие = это отличная возможность" +
                    " принять участие в организации и проведении спортивных мероприятий в нашем " +
                    "городе. \nМероприятие состоится 25.05.23 на стадионе Динамо",
            state = "Accepted"
        ),
        EventDetail(
            id = 2,
            title = "Спорт для всех",
            date = "25.06.23",
            direction = "Патриотическое",
            address = "г. Пушкино, ул. Колотушкина, д. 2",
            organizer = "Лорд Волдеморт",
            description = "Наше спортивное волонтерское мероприятие = это отличная возможность" +
                    " принять участие в организации и проведении спортивных мероприятий в нашем " +
                    "городе. \nМероприятие состоится 25.05.23 на стадионе Динамо",
            state = "Under review"
        ),
        EventDetail(
            id = 3,
            title = "Спорт для всех",
            date = "25.06.23",
            direction = "Духовно-нравственное",
            address = "г. Пушкино, ул. Колотушкина, д. 2",
            organizer = "Лорд Волдеморт",
            description = "Наше спортивное волонтерское мероприятие = это отличная возможность" +
                    " принять участие в организации и проведении спортивных мероприятий в нашем " +
                    "городе. \nМероприятие состоится 25.05.23 на стадионе Динамо",
            state = "Declined"
        ),
        EventDetail(
            id = 4,
            title = "Спорт для всех",
            date = "25.06.23",
            direction = "Социальное",
            address = "г. Пушкино, ул. Колотушкина, д. 2",
            organizer = "Лорд Волдеморт",
            description = "Наше спортивное волонтерское мероприятие = это отличная возможность" +
                    " принять участие в организации и проведении спортивных мероприятий в нашем " +
                    "городе. \nМероприятие состоится 25.05.23 на стадионе Динамо",
            state = "Not submitted"
        )
    )

    val events = listOf(
        Event(
            id = 1,
            title = "Название",
            date = "25.06.23",
            direction = "Спортивное",
            points = null
        ),
        Event(
            id = 2,
            title = "Название",
            date = "25.06.23",
            direction = "Патриотическое",
            points = null
        ),
        Event(
            id = 3,
            title = "Название",
            date = "25.06.23",
            direction = "Духовно-нравственное",
            points = null
        )
    )

    val currentUser = User(
        id = 1,
        avatarUrl = "https://cs6.pikabu.ru/avatars/663/v663703-279838185.jpg",
        name = "Татьяна",
        surname = "Кудрявцева",
        city = "Москва",
        birthday = "21.02.2000",
        phone = "8 123 456 78 90",
        email = "email.email.com",
        organization = "Valonter ООО",
        points = 234,
        currentEvents = events,
        previousEvents = listOf(
            Event(
                id = 4,
                title = "Название",
                date = "23.04.23",
                direction = "Социальное",
                points = 80
            ),
            Event(
                id = 5,
                title = "Название",
                date = "23.04.23",
                direction = "Культурное",
                points = 80
            ),
            Event(
                id = 6,
                title = "Название",
                date = "23.04.23",
                direction = "Спортивное",
                points = 80
            ),
            Event(
                id = 7,
                title = "Название",
                date = "23.04.23",
                direction = "Спортивное",
                points = 80
            ),
            Event(
                id = 8,
                title = "Название",
                date = "23.04.23",
                direction = "Спортивное",
                points = 80
            ),
            Event(
                id = 9,
                title = "Название",
                date = "23.04.23",
                direction = "Спортивное",
                points = 80
            )
        )
    )
}