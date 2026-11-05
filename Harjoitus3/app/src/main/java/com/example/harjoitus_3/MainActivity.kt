package com.example.harjoitus_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileScaffold()
        }
    }
}



@Preview
@Composable
fun ProfileHeaderPreview() {
    CardHeader(
        name = "Olario",
        role = "Super Giant",
        description = "Super Giants are more visually similar to Boxer Giants than the regular ones, having a belt and compression bandages around the wrist and a different hairstyle.",
        imageRef = R.drawable.giant,
        modifier = Modifier.padding(8.dp)
    )
}

