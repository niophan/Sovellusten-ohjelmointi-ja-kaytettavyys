package com.example.harjoitus6

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.time.LocalTime

@Composable
fun DiscountCalculator() {
    var priceTag by rememberSaveable { mutableStateOf("") }
    var percentTag by rememberSaveable { mutableStateOf("") }
    var finalPrice by rememberSaveable { mutableDoubleStateOf(0.0) }
    var hasError by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),

    ) {
        Text(
            text = stringResource(R.string.discount_calculator_title),
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = stringResource(R.string.discount_calculator_subtitle)
        )

        OutlinedTextField(
            value = priceTag,
            onValueChange = {
                priceTag = it
                hasError = false
            },
            label = {
                Text(stringResource(R.string.product_price_label))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = percentTag,
            onValueChange = {
                percentTag = it
                hasError = false
            },
            label = {
                Text(stringResource(R.string.discount_percent_label))
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
                        hasError = true
                        return@Button
                    }

                    hasError = false
                    val discount = percentTag.toDoubleOrNull()
                        ?: if (LocalTime.now().hour >= 21) 60.0 else 30.0

                    finalPrice = calculateDiscount(price, discount)
                    println("Alennus laskettu: $finalPrice")

                },
                modifier = Modifier.weight(1f),
                enabled = priceTag.isNotEmpty()
            ) {
                Text(stringResource(R.string.button_calculate))
            }

            Button(
                onClick = {
                    priceTag = ""
                    percentTag = ""
                    finalPrice = 0.0
                    hasError = false
                },
                modifier = Modifier.weight(1f),
                enabled = priceTag.isNotEmpty() || percentTag.isNotEmpty() || finalPrice != 0.0
            ) {
                Text(stringResource(R.string.button_clear))
            }
        }

        if(hasError) {
            Text(
                text = stringResource(R.string.error_invalid_input),
                color = MaterialTheme.colorScheme.error
            )
        }

        Text(
            text = stringResource(R.string.final_price_format, finalPrice),
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = stringResource(R.string.discount_calculator_note),
            style = MaterialTheme.typography.bodyLarge
        )

        ProductsListScreen()
    }
}

fun calculateDiscount(price: Double, discount: Double): Double {
    return price * ((100 - discount) / 100.0)
}
