package com.example.harjoitus4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RegistrationSummary(
    name: String,
    participantCount: Int
) {
    Column(
        modifier = Modifier.padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Yhteenveto",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Nimi: $name",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Osallistujia: $participantCount",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}