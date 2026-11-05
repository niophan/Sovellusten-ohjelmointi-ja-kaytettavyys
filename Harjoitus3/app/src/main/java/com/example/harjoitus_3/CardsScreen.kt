package com.example.harjoitus_3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@Preview
@Composable
fun CardsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        CardHeader(
            name = stringResource(R.string.grace_name),
            role = stringResource(R.string.healer_role),
            description = stringResource(R.string.healer_desc),
            imageRef = R.drawable.healer,
            modifier = Modifier.padding(8.dp)
        )
        CardHeader(
            name = stringResource(R.string.dragonheart_name),
            role = stringResource(R.string.baby_dragon_role),
            description = stringResource(R.string.baby_dragon_desc),
            imageRef = R.drawable.babydra,
            modifier = Modifier.padding(8.dp)
        )
        CardHeader(
            name = stringResource(R.string.frostborn_name),
            role = stringResource(R.string.ice_golem),
            description = stringResource(R.string.ice_golem_desc),
            imageRef = R.drawable.icogolem,
            modifier = Modifier.padding(8.dp)
        )
        CardHeader(
            name = stringResource(R.string.dreadforge_name),
            role = stringResource(R.string.ram_rider_role),
            description = stringResource(R.string.ram_rider_desc),
            imageRef = R.drawable.ramrider,
            modifier = Modifier.padding(8.dp)
        )
        CardHeader(
            name = stringResource(R.string.stoner_name),
            role = stringResource(R.string.bowler_role),
            description = stringResource(R.string.bowler_desc),
            imageRef = R.drawable.bowler,
            modifier = Modifier.padding(8.dp)
        )
        CardHeader(
            name = stringResource(R.string.stormbreaker_name),
            role = stringResource(R.string.super_wizard),
            description = stringResource(R.string.super_wizard_desc),
            imageRef = R.drawable.wizard,
            modifier = Modifier.padding(8.dp)
        )
        CardHeader(
            name = stringResource(R.string.warborn_name),
            role = stringResource(R.string.p_e_k_k_a),
            description = stringResource(R.string.pekka_desc),
            imageRef = R.drawable.pekka,
            modifier = Modifier.padding(8.dp)
        )
        CardHeader(
            name = stringResource(R.string.titanfall_name),
            role = stringResource(R.string.super_giant_role),
            description = stringResource(R.string.super_giant_desc),
            imageRef = R.drawable.giant,
            modifier = Modifier.padding(8.dp)
        )
        CardHeader(
            name = stringResource(R.string.ragebound_name),
            role = stringResource(R.string.super_archery_role),
            description = stringResource(R.string.super_archery_desc),
            imageRef = R.drawable.archery,
            modifier = Modifier.padding(8.dp)
        )
    }
}