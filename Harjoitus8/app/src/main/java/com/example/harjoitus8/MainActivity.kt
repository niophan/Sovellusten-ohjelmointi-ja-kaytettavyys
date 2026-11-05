package com.example.harjoitus8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.harjoitus8.ui.theme.Harjoitus8Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorkoutSessionScreen()
        }
    }

    override fun onPause() {
        super.onPause()
        println("Activity paused")
    }

    override fun onStop() {
        super.onStop()
        println("Activity stopped")
    }

    override fun onResume() {
        super.onResume()
        println("Activity resumed")
    }

}

