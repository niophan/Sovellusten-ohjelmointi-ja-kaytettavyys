package com.example.harjoitus8

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ExerciseRow(
    set: ExerciseSet,
    onChecked: () -> Unit
) {

    val background =
        if (set.completed)
            Color(0xFF8A6C5F)
        else
            Color.Transparent

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .background(background)
            .padding(16.dp),

        horizontalArrangement =
            Arrangement.SpaceEvenly,

        verticalAlignment =
            Alignment.CenterVertically

    ) {

        Text(
            text = set.id.toString(),
            color = Color.White
        )

        Text(
            text = "${set.weight}",
            color = Color.White
        )

        Text(
            text = "${set.reps}",
            color = Color.White
        )

        Checkbox(
            checked = set.completed,
            onCheckedChange = {
                onChecked()
            }
        )
    }
}