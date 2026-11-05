package com.example.harjoitus_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.MilitaryTech
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Style
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PlayerScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onSecondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = stringResource(R.string.profile_photo),
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.ossi_seidel),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.level_25),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(8.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    InfoDetails(
                        text = stringResource(R.string.battles_won),
                        number = "245",
                        imageVector = Icons.Default.Shield,
                        contentDescription = stringResource(R.string.shield),
                        tint = Color(0xFFFF0000)
                    )
                    InfoDetails(
                        text = stringResource(R.string.achievements),
                        number = "38",
                        imageVector = Icons.Default.EmojiEvents,
                        contentDescription = stringResource(R.string.achievement),
                        tint = Color(0xFFFFD700)
                    )
                    InfoDetails(
                        text = stringResource(R.string.cards_collected),
                        number = "9/250",
                        imageVector = Icons.Default.Style,
                        contentDescription = stringResource(R.string.cards),
                        tint = Color.Blue
                    )
                }
            }

            // Yhteystiedot
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ContactItem(label = stringResource(R.string.top_deck)) {
                    Text(text = stringResource(R.string.super_wizard), style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)
                    Text(text = stringResource(R.string.p_e_k_k_a), style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)
                    Text(text = stringResource(R.string.ice_golem), style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)

                }
                ContactItem(label = stringResource(R.string.recent_achievements)) {
                    InfoRow(
                        text = stringResource(R.string.arena_champion),
                        imageVector = Icons.Default.MilitaryTech,
                        contentDescription = stringResource(R.string.rank),
                        tint = Color.Magenta
                    )
                    InfoRow(
                        text = stringResource(R.string.card_collector),
                        imageVector = Icons.Default.Whatshot,
                        contentDescription = stringResource(R.string.fire),
                        tint =  Color(0xFFFF5722)
                    )
                    InfoRow(
                        text = stringResource(R.string.speed_runner),
                        imageVector = Icons.Default.Bolt,
                        contentDescription = stringResource(R.string.thunder),
                        tint = Color(0xFFFFEB3B)
                    )
                }
            }
        }
}

@Composable
fun ContactItem(label: String, content: @Composable () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = label, style = MaterialTheme.typography.labelMedium, color = Color.Gray)
        content()
    }
}


@Composable
fun InfoDetails(
    text: String,
    number: String,
    imageVector: ImageVector,
    contentDescription: String,
    tint: Color
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold
        )
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),

            ) {
            Icon(imageVector = imageVector, contentDescription = contentDescription, tint = tint)
            Text(
                text = number,
                style = MaterialTheme.typography.bodyMedium
            )

        }

    }
}


