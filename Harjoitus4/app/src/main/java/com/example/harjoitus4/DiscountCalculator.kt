package com.example.harjoitus4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.time.LocalTime

@Composable
fun DiscountCalculator() {
    var priceTag by rememberSaveable { mutableStateOf("") }
    var percentTag by rememberSaveable { mutableStateOf("") }
    var finalPrice by rememberSaveable { mutableDoubleStateOf(0.0) }
    var errorMessage by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Ale-laskuri",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Syötä tuotteen hinta ja alennusprosentti."
        )

        OutlinedTextField(
            value = priceTag,
            onValueChange = { priceTag = it },
            label = {
                Text("Tuoteen hinta (euro)")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = percentTag,
            onValueChange = { percentTag = it },
            label = {
                Text("Alennusprosentti (%)")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = {
                    val price = priceTag.toDoubleOrNull()
                    if(price == null) {
                        errorMessage = "Virheellinen käyttäjän syöte!"
                        return@Button
                    }

                    val discount = percentTag.toDoubleOrNull()
                        ?: if (LocalTime.now().hour >= 21) 60.0 else 30.0

                    finalPrice = calculateDiscount(price, discount)
                    println("Alennus laskettu: $finalPrice")

                },
                modifier = Modifier.weight(1f),
                enabled = priceTag.isNotEmpty()
            ) {
                Text("Laske")
            }

            Button(
                onClick = {
                    priceTag = ""
                    percentTag = ""
                    finalPrice = 0.0
                },
                modifier = Modifier.weight(1f),
                enabled = priceTag.isNotEmpty() || percentTag.isNotEmpty() || finalPrice != 0.0
            ) {
                Text("Tyhjennä")
            }
        }

        if(errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }

        Text(
            text = "Loppuhinta: %.1f €".format(finalPrice),
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "HUOM: Sovellus auttaa opiskelijoita laskemaan nopeasti alennettujen tuotteiden hinnan S-ryhmän myymälöissä. " +
                    "Jos alennusprosenttia ei anneta, oletusalennus on 30 %. " +
                    "Kello 21 jälkeen oletusalennus on automaattisesti 60 %.",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

fun calculateDiscount(price: Double, discount: Double): Double {
    return price * ((100 - discount) / 100.0)
}