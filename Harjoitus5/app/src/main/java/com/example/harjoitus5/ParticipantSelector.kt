package com.example.harjoitus5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun ParticipantSelector(
    participantCount: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
)
{
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ){
        Button(
            onClick = onIncrease,
            enabled = participantCount < 5,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(R.string.button_add))
        }
        Button(
            onClick = onDecrease,
            enabled = participantCount > 1,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(R.string.button_subtract))
        }
    }
}