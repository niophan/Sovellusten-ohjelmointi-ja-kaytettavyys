package com.example.harjoitus8

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ExerciseCard(
    exercise: Exercise,
    onToggleExpand: () -> Unit,
    onCheckSet: (Int) -> Unit,
    onEdit: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF675454)
        )
    ) {

        Column {

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                horizontalArrangement =
                    Arrangement.SpaceBetween,

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Text(
                    text = exercise.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Row {

                    IconButton(
                        onClick = onEdit
                    ) {

                        Icon(
                            Icons.Default.MoreVert,
                            contentDescription = null,
                            tint = Color(0xFFFFB785)
                        )
                    }

                    IconButton(
                        onClick = onToggleExpand
                    ) {

                        Icon(
                            if (exercise.expanded)
                                Icons.Default.KeyboardArrowUp
                            else
                                Icons.Default.KeyboardArrowDown,

                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }

            AnimatedVisibility(exercise.expanded) {

                Column {

                    exercise.sets.forEach { set ->

                        ExerciseRow(
                            set = set,
                            onChecked = {
                                onCheckSet(set.id)
                            }
                        )
                    }
                }
            }
        }
    }
}