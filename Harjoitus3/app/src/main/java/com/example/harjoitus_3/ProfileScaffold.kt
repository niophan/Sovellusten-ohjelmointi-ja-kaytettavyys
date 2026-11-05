package com.example.harjoitus_3

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScaffold() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        // Topbar, BottomBar ja floatingAction button
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        when(currentRoute) {
                            "home" -> stringResource(R.string.title_arena)
                            "cards" -> stringResource(R.string.title_collection)
                            "profile" -> stringResource(R.string.title_player)
                            else -> ""
                        }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                actions = {
                    when(currentRoute) {
                        "home" -> {
                        }
                        "cards" -> {
                        }
                        "profile" -> {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Default.Settings, contentDescription = stringResource(R.string.settings))
                            }
                        }
                    }

                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = stringResource(R.string.nav_home)) },
                    label = { Text(stringResource(R.string.nav_home)) },
                    selected = currentRoute == "home",
                    onClick = { navController.navigate("home") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Email, contentDescription = stringResource(R.string.nav_cards)) },
                    label = { Text(stringResource(R.string.nav_cards)) },
                    selected = currentRoute == "cards",
                    onClick = { navController.navigate("cards") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = stringResource(R.string.nav_profile)) },
                    label = { Text(stringResource(R.string.nav_profile)) },
                    selected = currentRoute == "profile",
                    onClick = { navController.navigate("profile") }
                )
            }
        },

        floatingActionButton = {
            when(currentRoute) {
                "profile" -> {
                    FloatingActionButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Edit, contentDescription = stringResource(R.string.edit))
                    }
                }
            }
        }
    )
    { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "profile",
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(24.dp),
        ) {
            composable("home") { HomeScreen() }
            composable("profile") { PlayerScreen() }
            composable("cards") { CardsScreen() }
        }
    }
}




