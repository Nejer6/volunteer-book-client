# Мобильного приложения для волонтеров

Данное мобильное приложение предназначено для волонтеров и позволяет им:

1. Просматривать предстоящие мероприятия и записываться на них.
2. В профиле пользователя отображаются как прошедшие, так и текущие мероприятия, а также ранг волонтера, который зависит от оценок, полученных на прошлых мероприятиях.
3. Получать оценки за свою работу на мероприятии от вожатых.
4. Вожатые, находящиеся выше в иерархии приложения, могут создавать новые мероприятия, просматривать заявки и выбирать волонтеров для участия в мероприятиях.

# Используемые технологии

- Язык программирования: Kotlin
- Фреймворки: Jetpack Compose, Ktor

# Установка и запуск приложения

1. Клонируете репозиторий
2. Обращаетесь к администратору приложения для создания аккаунта
3. Создаете apk с помощью "./gradlew assembleRelease"
4. Устанавливаете apk

# Руководство пользователя
## Вход в аккаунт
На экране авторизации пользователь вводит почту и пароль от аккаунта

![image](https://github.com/Nejer6/volunteer-book-client/assets/94484058/a6549c7b-dd52-439c-89e9-f20d08de22e0)

## Личный кабинет
На данном экране пользователь может видеть информацию о себе, текущие(на которые пользователь зарегестрировался) и прошлые мероприятия.

![image](https://github.com/Nejer6/volunteer-book-client/assets/94484058/02578fad-b8ed-4189-9294-cfcb3c22d6d5)

У прошедших мероприятий отображаются очки рейтинга выданные вожатым.

![image](https://github.com/Nejer6/volunteer-book-client/assets/94484058/f0bb5f90-2328-4903-be32-eeab489d57a0)

## Мероприятия
В данной вкладке вы можете видеть все мероприятия на которые вы можете подать заявку.

![image](https://github.com/Nejer6/volunteer-book-client/assets/94484058/8020ac27-5ef7-475b-80fe-99aab6d36a48)

## Детали мероприятия
Нажав на мероприятие пользователь может получить дополнительрную информацию о мероприятии, а так же подать или посмотреть статус своей заявки.

![image](https://github.com/Nejer6/volunteer-book-client/assets/94484058/532c28a1-95b7-4b6c-a7a8-4c2516a4bd0e)

# Руководство для вожатого
Войдя в аккаунт как вожатый, вы получаете расширенный функционал.

![image](https://github.com/Nejer6/volunteer-book-client/assets/94484058/01bdc937-eb32-4ef0-926b-09b155e056e3)

(Экран мероприятий вожатого)


## Создание мероприятий
Нажав на *плюс* на экране мероприятий вожатый может создать новое мероприятие.

![image](https://github.com/Nejer6/volunteer-book-client/assets/94484058/8a2c7546-6732-42b6-aa9e-c24fe87c147a)


## Рассмотрение заявок
Так же вожатый может рассматривать заявки на созданные им мероприятия.

![image](https://github.com/Nejer6/volunteer-book-client/assets/94484058/714413a9-bbdb-44f3-9311-47c5f5faa0fb)

Вожатый может просматривать профиль всех людей которые подали свои заявки.

![image](https://github.com/Nejer6/volunteer-book-client/assets/94484058/a881643a-c73c-4a53-93cf-1600190d61fc)

## Начисление баллов и удаление участников
Вожатый может начислить баллы участникам в соответствии с их активностью на мероприятии. Так же вожатый может удалить участника из мероприятия.

![image](https://github.com/Nejer6/volunteer-book-client/assets/94484058/fd448bed-e715-4af5-900d-cf384e9cb082)

# Дизайн приложения
https://www.figma.com/file/P6PbALjwZIQLRdtCiEWDKD/Untitled?type=design&node-id=0-1

# Mobile application for volunteers

This mobile application is designed for volunteers and allows them to:

1. View upcoming events and sign up for them.
2. The user profile displays both past and current events, as well as the rank of the volunteer, which depends on the ratings received at past events.
3. Receive marks for their work at the event from counselors.
4. Counselors who are higher in the hierarchy of the application can create new events, view applications and select volunteers to participate in events.

# Technologies used

- Programming language: Kotlin
- Frameworks: Jetpack Compose, Kotor

# Installing and launching the application

1. Clone the repository
2. Contact the application administrator to create an account
3. Create an apk using "./gradlew assembleRelease"
4. Install the apk
