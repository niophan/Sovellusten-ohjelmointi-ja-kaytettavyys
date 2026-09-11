package com.example.harjoitus_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileScreen()
        }
    }
}

@Preview
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        InfoRow()
        ProfileHeader(
            name = "Raksai",
            role = "Super Wizard",
            description = "Super Wizard is positively charged with magical energy! He's either the smartest person in the room... or else he blows the whole room to bits.",
            imageRef = R.drawable.wizard,
            modifier = Modifier.padding(8.dp)
        )
        ProfileHeader(
            name = "Olario",
            role = "Super Giant",
            description = "Super Giants are more visually similar to Boxer Giants than the regular ones, having a belt and compression bandages around the wrist and a different hairstyle.",
            imageRef = R.drawable.giant,
            modifier = Modifier.padding(8.dp)
        )
        ProfileHeader(
            name ="Nami",
            role= "Super Archery",
            description = "Having achieved serious arm strength, the Super Archer can now threaten targets several buildings away.",
            imageRef = R.drawable.archery,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
fun ProfileHeaderPreview() {
    ProfileHeader(
        name = "Olario",
        role = "Super Giant",
        description = "Super Giants are more visually similar to Boxer Giants than the regular ones, having a belt and compression bandages around the wrist and a different hairstyle.",
        imageRef = R.drawable.giant,
        modifier = Modifier.padding(8.dp)
    )
}

