package com.example.harjoitus_3

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun CardActions () {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            painter = painterResource(id = R.drawable.heart),
            contentDescription = stringResource(R.string.add_to_favorites),
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(32.dp)

        )
    }
}