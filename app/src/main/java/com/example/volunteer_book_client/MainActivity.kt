package com.example.volunteer_book_client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.volunteer_book_client.data.network.ApiClient
import com.example.volunteer_book_client.data.repository.EventRepository
import com.example.volunteer_book_client.data.repository.UserRepository
import com.example.volunteer_book_client.ui.authorization.AuthorizationScreen
import com.example.volunteer_book_client.ui.events.CreateEventScreen
import com.example.volunteer_book_client.ui.events.EventDetailRoute
import com.example.volunteer_book_client.ui.events.EventEditScreen
import com.example.volunteer_book_client.ui.events.EventsRoute
import com.example.volunteer_book_client.ui.profile.ParticipantProfileScreen
import com.example.volunteer_book_client.ui.profile.ProfileScreen
import com.example.volunteer_book_client.ui.profile.RequestProfileScreen
import com.example.volunteer_book_client.ui.theme.VolunteerbookclientTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val apiClient = ApiClient("http://192.168.0.109:8080")
    private val userRepository = UserRepository(apiClient)
    private val eventRepository = EventRepository(apiClient)
    private val volunteerViewModel = VolunteerViewModel(userRepository, eventRepository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VolunteerbookclientTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold {
                        VolunteerNavHost(
                            navController = navController,
                            modifier = Modifier.padding(it),
                            viewModel = volunteerViewModel
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun VolunteerNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: VolunteerViewModel
) {
    val coroutineScope = rememberCoroutineScope()
    NavHost(
        navController = navController,
        startDestination = Authorization.route,
        modifier = modifier
    ) {

        composable(route = Authorization.route) {
            AuthorizationScreen { email, password ->
                coroutineScope.launch(Dispatchers.IO) {
                    viewModel.getSelfProfile(email, password)
                    if (viewModel.profile != null) {
                        coroutineScope.launch(Dispatchers.Main) {
                            navController.popBackStack()
                            navController.navigate(Profile.route)
                        }
                    }
                }
            }
        }

        composable(route = Profile.route) {
            ProfileScreen(
                user = viewModel.profile,
                onEventsClick = {
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.getEvents()
                        coroutineScope.launch(Dispatchers.Main) {
                            navController.navigateSingleTopTo(Events.route)
                        }
                    }
                },
                onEventClick = {
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.getEventDetailById(it)
                        coroutineScope.launch(Dispatchers.Main) {
                            navController.navigateSingleTopTo(EventDetail.route)
                        }
                    }
                }
            )
        }

        composable(route = Events.route) {
            EventsRoute(
                viewModel = viewModel,
                onProfileClick = {
                    navController.navigateSingleTopTo(Profile.route)
                },
                onEventClick = {
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.getEventDetailById(it)
                        coroutineScope.launch(Dispatchers.Main) {
                            navController.navigateSingleTopTo(EventDetail.route)
                        }
                    }
                },
                onAddClick = {
                    navController.navigateSingleTopTo(CreateEvent.route)
                },
                onEditClick = {
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.getEventEdit(it)
                        coroutineScope.launch(Dispatchers.Main) {
                            navController.navigateSingleTopTo(EventEdit.route)
                        }
                    }
                }
            )
        }

        composable(route = EventDetail.route) {
            EventDetailRoute(
                viewModel = viewModel,
                onSubmit = {
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.postRequest(it)
                    }
                }
            )
        }

        composable(route = CreateEvent.route) {
            CreateEventScreen(
                onUndo = {
                    navController.popBackStack()
                },
                onSend = {
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.createEvent(it)
                        coroutineScope.launch(Dispatchers.Main) {
                            navController.popBackStack()
                        }
                    }
                }
            )
        }
        
        composable(route = EventEdit.route) {
            EventEditScreen(
                eventEditDTO = viewModel.currentEventEdit!!,
                acceptRequest = { eventId, userId ->
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.acceptRequest(eventId, userId)
                    }
                },
                declineRequest = { eventId, userId ->
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.declineRequest(eventId, userId)
                    }
                },
                deleteParticipant = { eventId, userId ->
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.deleteParticipant(eventId, userId)
                    }
                },
                updatePoints = { eventId, userId, points ->
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.updatePoints(eventId, userId, points)
                    }
                },
                onRequestClick = {
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.getUserProfile(it)
                        coroutineScope.launch(Dispatchers.Main) {
                            navController.navigateSingleTopTo(RequestUserProfile.route)
                        }
                    }
                },
                onParticipantClick = {
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.getUserProfile(it)
                        coroutineScope.launch(Dispatchers.Main) {
                            navController.navigateSingleTopTo(ParticipantUserProfile.route)
                        }
                    }
                }
            )
        }

        composable(route = RequestUserProfile.route) {
            RequestProfileScreen(
                user = viewModel.userProfile,
                onDecline = {
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.declineRequest(viewModel.currentEventEdit!!.id, it)
                        coroutineScope.launch(Dispatchers.Main) {
                            navController.popBackStack()
                        }
                    }
                },
                onAccept = {
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.acceptRequest(viewModel.currentEventEdit!!.id, it)
                        coroutineScope.launch(Dispatchers.Main) {
                            navController.popBackStack()
                        }
                    }
                },
                onEventClick = {
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.getEventDetailById(it)
                        coroutineScope.launch(Dispatchers.Main) {
                            navController.navigateSingleTopTo(EventDetail.route)
                        }
                    }
                }
            )
        }

        composable(route = ParticipantUserProfile.route) {
            ParticipantProfileScreen(
                user = viewModel.userProfile,
                onEventClick = {
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.getEventDetailById(it)
                        coroutineScope.launch(Dispatchers.Main) {
                            navController.navigateSingleTopTo(EventDetail.route)
                        }
                    }
                }
            )
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
