package com.example.volunteer_book_client.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Characteristics(
    titleAndValueList: List<Pair<String, String>>,
    modifier: Modifier = Modifier,
    spacerDp: Dp = 0.dp
) {
    Column(modifier = modifier) {
        titleAndValueList.forEachIndexed { id, it ->
            Characteristic(title = it.first, value = it.second, modifier = Modifier.fillMaxWidth())
            if (id != titleAndValueList.size - 1) {
                Spacer(modifier = Modifier.height(spacerDp))
            }
        }
    }
}

@Composable
fun Characteristic(title: String, value: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(2.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = title, color = MaterialTheme.colors.primary)
        Text(text = value)
    }
}