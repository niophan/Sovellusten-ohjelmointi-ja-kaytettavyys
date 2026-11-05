package com.example.harjoitus_3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun InfoRow (
    text: String,
    imageVector: ImageVector,
    contentDescription: String,
    tint: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),

        ) {
        Icon(imageVector = imageVector, contentDescription = contentDescription, tint = tint)
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium
        )

    }
}