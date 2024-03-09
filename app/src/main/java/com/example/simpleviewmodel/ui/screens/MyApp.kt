package com.example.simpleviewmodel.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.example.simpleviewmodel.model.MainViewModel
import com.example.simpleviewmodel.ui.navigation.MyMenu
import com.example.simpleviewmodel.ui.navigation.MyNavBar
import com.example.simpleviewmodel.ui.navigation.MyTopBar
import com.example.simpleviewmodel.ui.navigation.NavDestination
import com.example.simpleviewmodel.ui.navigation.bottomBarNavDestinations
import com.example.simpleviewmodel.ui.navigation.dialogDestinations
import com.example.simpleviewmodel.ui.navigation.navDestinations

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val viewModel: MainViewModel = viewModel()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    var showMenu by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            MyTopBar(
                navController = navController,
                screens = navDestinations,
                onMenuClick = { showMenu = !showMenu },
            )
        },
        bottomBar = {
            if (bottomBarNavDestinations.any { it.route == currentRoute }) {
                MyNavBar(
                    navController = navController,
                    screens = bottomBarNavDestinations
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavDestination.Home.route,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            // Screens via BottomBar und Fullscreens
            navDestinations.forEach { screen ->
                composable(screen.route) {
                    screen.content(navController, viewModel)
                }
            }
            // Dialog Screens
            dialogDestinations.forEach { screen ->
                dialog(screen.route) {
                    screen.content(navController, viewModel)
                }
            }
        }

        MyMenu(
            showMenu = showMenu,
            navController = navController,
            paddingValues = paddingValues,
            onToggleMenu = { showMenu = !showMenu }
        )

    }

}

