package com.example.harjoitus8

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class ExerciseSet(
    val id: Int,
    val weight: Int,
    val reps: Int,
    val completed: Boolean = false
)

data class Exercise(
    val id: Int,
    val name: String,
    val expanded: Boolean = true,
    val sets: List<ExerciseSet>
)

class WorkoutViewModel : ViewModel() {

    private val _seconds = MutableStateFlow(0)
    val seconds = _seconds.asStateFlow()

    private var timerJob: Job? = null

    private val _workoutFinished = MutableStateFlow(false)
    val workoutFinished = _workoutFinished.asStateFlow()

    private val _exercises = MutableStateFlow(
        listOf(
            Exercise(
                id = 1,
                name = "Leg Press",
                sets = listOf(
                    ExerciseSet(1, 80, 1),
                    ExerciseSet(2, 80, 1),
                    ExerciseSet(3, 80, 1)
                )
            ),
            Exercise(
                id = 2,
                name = "Dumbbell Bench Press",
                sets = listOf(
                    ExerciseSet(1, 80, 1),
                    ExerciseSet(2, 80, 1),
                    ExerciseSet(3, 80, 1)
                )
            )
        )
    )

    val exercises = _exercises.asStateFlow()

    fun startTimer() {
        timerJob?.cancel()
        if (timerJob != null) return

        timerJob = viewModelScope.launch {
            while (true) {
                delay(1000)
                _seconds.value++
            }
        }
    }

    fun stopTimer() {
        timerJob?.cancel()
        timerJob = null
        _workoutFinished.value = true
    }

    fun toggleExpanded(exerciseId: Int) {
        _exercises.value = _exercises.value.map { exercise ->
            if (exercise.id == exerciseId) {
                exercise.copy(expanded = !exercise.expanded)
            } else {
                exercise
            }
        }
    }

    fun toggleSetCompleted(exerciseId: Int, setId: Int) {
        _exercises.value = _exercises.value.map { exercise ->
            if (exercise.id == exerciseId) {
                exercise.copy(
                    sets = exercise.sets.map { set ->
                        if (set.id == setId) {
                            set.copy(completed = !set.completed)
                        } else {
                            set
                        }
                    }
                )
            } else {
                exercise
            }
        }
    }

    fun updateWeight(exerciseId: Int, setId: Int, newWeight: Int) {
        _exercises.value = _exercises.value.map { exercise ->
            if (exercise.id == exerciseId) {
                exercise.copy(
                    sets = exercise.sets.map { set ->
                        if (set.id == setId) {
                            set.copy(weight = newWeight)
                        } else {
                            set
                        }
                    }
                )
            } else {
                exercise
            }
        }
    }

    fun updateReps(exerciseId: Int, setId: Int, newReps: Int) {
        _exercises.value = _exercises.value.map { exercise ->
            if (exercise.id == exerciseId) {
                exercise.copy(
                    sets = exercise.sets.map { set ->
                        if (set.id == setId) {
                            set.copy(reps = newReps)
                        } else {
                            set
                        }
                    }
                )
            } else {
                exercise
            }
        }
    }

    fun addSet(exerciseId: Int) {
        _exercises.value = _exercises.value.map { exercise ->
            if (exercise.id == exerciseId) {
                exercise.copy(
                    sets = exercise.sets + ExerciseSet(
                        id = exercise.sets.size + 1,
                        weight = 80,
                        reps = 1
                    )
                )
            } else {
                exercise
            }
        }
    }
}
