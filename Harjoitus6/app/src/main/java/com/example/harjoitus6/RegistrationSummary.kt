package com.example.harjoitus6

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
            text = stringResource(R.string.summary_title),
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = stringResource(R.string.summary_name, name),
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = stringResource(R.string.summary_participants, participantCount),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
