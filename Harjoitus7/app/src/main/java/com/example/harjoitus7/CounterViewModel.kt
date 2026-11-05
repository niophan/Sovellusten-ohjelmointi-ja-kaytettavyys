package com.example.harjoitus7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel;


class CounterViewModel : ViewModel() {
    var count by mutableIntStateOf(0)
        private set

    fun increment() {
        count++
    }

    fun decrement() {
        if(count > 0) {
            count--;
        }
    }

    fun reset() {
        count = 0;
    }
}

@Preview(showBackground = true)
@Composable
fun CounterScreen(counterViewModel: CounterViewModel = viewModel()) {
    val count = counterViewModel.count

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = "Count: $count",
            style = MaterialTheme.typography.headlineMedium
            )

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Button(
                onClick = { counterViewModel.decrement() },
                enabled = count > 0,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Pienennä")
            }
            Button(
                onClick = { counterViewModel.reset() },
                enabled = count > 0,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Nollaa")
            }
            Button(
                onClick = { counterViewModel.increment() },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Kasvata")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

    }
}
