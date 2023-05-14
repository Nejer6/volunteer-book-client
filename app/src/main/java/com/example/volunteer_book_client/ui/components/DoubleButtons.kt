package com.example.volunteer_book_client.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun DoubleButtons(
    modifier: Modifier = Modifier,
    state: Boolean = true,
    onLeftButtonClick: () -> Unit = {},
    onRightButtonClick: () -> Unit = {},
    leftButtonContent: @Composable () -> Unit = {},
    rightButtonContent: @Composable () -> Unit = {}
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        val buttonActive = ButtonDefaults.buttonColors()
        val buttonDefaults = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.background
        )

        Button(
            onClick = {
                onLeftButtonClick()
            },
            modifier = Modifier
                .weight(0.5f)
                .fillMaxHeight(),
            colors = if (state) buttonActive else buttonDefaults,
            shape = RoundedCornerShape(0.dp)
        ) {
            leftButtonContent()
        }

        Button(
            onClick = {
                onRightButtonClick()
            },
            modifier = Modifier
                .weight(0.5f)
                .fillMaxHeight(),
            colors = if (!state) buttonActive else buttonDefaults,
            shape = RoundedCornerShape(0.dp)

        ) {
            rightButtonContent()
        }
    }
}