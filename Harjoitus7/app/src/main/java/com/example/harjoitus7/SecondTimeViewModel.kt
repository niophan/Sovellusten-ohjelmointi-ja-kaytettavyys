package com.example.harjoitus7


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TimeViewModel : ViewModel() {
    private var timerJob: Job? = null
    private val _seconds = MutableStateFlow(0)
    val seconds = _seconds.asStateFlow()
    private val _minutes = MutableStateFlow(0)
    val minutes = _minutes.asStateFlow()
    private val _hours = MutableStateFlow(0)
    val hours = _hours.asStateFlow()
    private val _timerRunning = MutableStateFlow(true)

    init {
        startTimer()
    }

    fun activateTimer() {
        startTimer()
    }

    fun deactivateTimer() {
        stopTimer()
    }

    fun reset() {
        _seconds.value = 0
        _minutes.value = 0
        _hours.value = 0
    }

    private fun startTimer() {
        timerJob?.cancel()
        _timerRunning.value = true

        timerJob = viewModelScope.launch {
            while (_timerRunning.value) {
                delay(1000)
                _seconds.value++

                if (_seconds.value >= 60) {
                    _seconds.value = 0
                    _minutes.value++
                }
                if (_minutes.value >= 60) {
                    _minutes.value = 0
                    _hours.value++
                }
                if (_hours.value >= 24) {
                    _seconds.value = 0
                    _minutes.value = 0
                    _hours.value = 0
                }
            }
        }
    }
    private fun stopTimer() {
        _timerRunning.value = false
        timerJob?.cancel()
    }
}

@Composable
fun TimerScreen(viewModel: TimeViewModel = viewModel()) {
    val seconds by viewModel.seconds.collectAsStateWithLifecycle()
    val minutes by viewModel.minutes.collectAsStateWithLifecycle()
    val hours by viewModel.hours.collectAsStateWithLifecycle()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Timer: $hours:$minutes:$seconds",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(25.dp)
        ) {
            Button(
                onClick = { viewModel.activateTimer() },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Käynnistä")
            }
            Button(
                onClick = { viewModel.reset() },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Nollaa")
            }
            Button(onClick = { viewModel.deactivateTimer() },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Pysäytä")
            }
        }

    }
}
