package com.example.harjoitus7

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun OpenWebsiteAndLocation() {
    val context = LocalContext.current
    val webUrl = "https://kotlinlang.org/"
    val location = "Hämeenkatu, Tampere"
    val locationUri = Uri.parse("geo:0,0?q=${Uri.encode(location)}")

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Verkkosivun avaaminen",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Verkkosivun nimi: Kotlin",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = "Verkkosivun osoite: ${webUrl}",
            style = MaterialTheme.typography.bodySmall
        )
        Button(
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webUrl))
            try {
                context.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                println("Error opening website")
                throw IllegalStateException(
                    "Virhe avattaessa verkkosivua: ${intent}",
                    e
                )
            }
        }) {
            Text(text = "Avaa verkkosivu")
        }

        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, locationUri)
                try {
                    context.startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    println("Error opening location")
                    throw IllegalStateException(
                        "Virhe avattaessa sijaintia: ${intent}",
                        e
                    )
                }
            }
        ) {
            Text(text = "Avaa sijainti")
        }
    }
}


