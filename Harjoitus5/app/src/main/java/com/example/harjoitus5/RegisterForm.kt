package com.example.harjoitus5

import androidx.compose.runtime.mutableIntStateOf

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun RegisterForm() {
    var name by rememberSaveable { mutableStateOf("") }
    var participantCount by rememberSaveable { mutableIntStateOf(1) }
    var isConfirmed by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.registration_form_title),
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = stringResource(R.string.registration_form_subtitle),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        RegistrationScreen(
            name = name,
            participantCount = participantCount,
            onNameChange = {
                    newName -> name = newName
                isConfirmed = false },

            )

        ParticipantSelector(
            participantCount = participantCount,
            onIncrease = {
                participantCount++
                isConfirmed = false
            },
            onDecrease = {
                participantCount--
                isConfirmed = false
            }
        )

        Button(
            onClick = {
                isConfirmed = true
            },
            enabled = name.isNotBlank(),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(stringResource(R.string.button_confirm))
        }


        if(isConfirmed) {
            RegistrationSummary(
                name = name,
                participantCount = participantCount
            )
        }

    }
}

