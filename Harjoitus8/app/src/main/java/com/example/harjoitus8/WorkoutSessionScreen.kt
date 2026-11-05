package com.example.harjoitus8

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutSessionScreen(
    viewModel: WorkoutViewModel = viewModel()
) {

    val exercises by viewModel.exercises.collectAsStateWithLifecycle()
    val seconds by viewModel.seconds.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.startTimer()
    }

    val minutes = seconds / 60
    val sec = seconds % 60

    Scaffold(

        containerColor = Color(0xFFD9CBB2)

    ) { padding ->

        LazyColumn(

            modifier = Modifier
                .padding(padding)
                .fillMaxSize()

        ) {

            item {

                HeaderSection(
                    timer = String.format("%02d:%02d", minutes, sec),
                    onBackClick = {
                        println("Back to workout list")
                    },
                    onFinishClick = {
                        viewModel.stopTimer()
                    }
                )
            }

            item {
                WarmupCard()
            }

            items(exercises) { exercise ->

                ExerciseCard(
                    exercise = exercise,
                    onToggleExpand = {
                        viewModel.toggleExpanded(exercise.id)
                    },
                    onCheckSet = { setId ->
                        viewModel.toggleSetCompleted(
                            exercise.id,
                            setId
                        )
                    },
                    onEdit = {
                        viewModel.addSet(exercise.id)
                    }
                )
            }
        }
    }
}