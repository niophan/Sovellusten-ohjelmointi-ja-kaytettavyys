package com.example.harjoitus4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiscountCalculator()
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


