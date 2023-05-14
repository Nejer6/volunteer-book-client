package com.example.volunteer_book_client.ui.authorization

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.volunteer_book_client.R

@Composable
fun AuthorizationScreen(
    onAuthorize: (email: String, password: String) -> Unit = { _, _ -> Unit }
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(19.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var login by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }

        Text(text = "Здравствуй, волонтер!", fontSize = MaterialTheme.typography.h6.fontSize)
        //todo add description
        Image(
            painter = painterResource(id = R.drawable.social),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Почта", color = MaterialTheme.colors.primary)

            Spacer(modifier = Modifier.height(16.dp))

            TextField(value = login, onValueChange = {
                login = it
            }, placeholder = {
                Text(text = "Email")
            }, modifier = Modifier.fillMaxWidth(), singleLine = true)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Пароль", color = MaterialTheme.colors.primary)

            Spacer(modifier = Modifier.height(16.dp))

            TextField(value = password, onValueChange = {
                password = it
            }, placeholder = {
                Text(text = "*********")
            }, visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                onAuthorize(login, password)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text(text = "Войти", fontSize = MaterialTheme.typography.h6.fontSize)
        }
    }
}