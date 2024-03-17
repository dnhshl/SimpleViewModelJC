package com.example.simpleviewmodel.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.example.simpleviewmodel.R
import com.example.simpleviewmodel.model.MainViewModel
import com.example.simpleviewmodel.ui.screens.AlertDialogScreen
import com.example.simpleviewmodel.ui.screens.DetailsScreen
import com.example.simpleviewmodel.ui.screens.HomeScreen
import com.example.simpleviewmodel.ui.screens.InfoScreen
import com.example.simpleviewmodel.ui.screens.OtherScreen1
import com.example.simpleviewmodel.ui.screens.OtherScreen2
import com.example.simpleviewmodel.ui.screens.SettingsScreen

sealed class MyNavDestination(
    val route: String,
    val title: Int = 0,
    val label: Int = 0,
    val selectedIcon: ImageVector = Icons.Default.Check,
    val unselectedIcon: ImageVector = Icons.Default.Check,
    val showArrowBack: Boolean = false,
    val content: @Composable (NavController, MainViewModel) -> Unit
) {

    // hier alle Bildschirme mit den notwendigen Infos dazu listen

    // BottomNavScreens

    object Home : MyNavDestination(
        route = "home",                          // eindeutige Kennung
        title = R.string.homeScreenTitle,        // Titel in der TopBar
        label = R.string.homeScreenLabel,        // Label in der BottomBar
        selectedIcon = Icons.Filled.Home,        // Icon in der BottomBar, wenn gewählt
        unselectedIcon =Icons.Outlined.Home,     // Icon in der BottomBar, wenn nicht gewählt
        // Lambda Funktion, über die der Screen aufgerufen wird
        content = { navController, viewModel -> HomeScreen(navController, viewModel) }
    )

    object Details : MyNavDestination(
        route = "detail",
        title = R.string.detailsScreenTitle,
        label = R.string.detailsScreenLabel,
        selectedIcon = Icons.Filled.CheckCircle,
        unselectedIcon = Icons.Outlined.CheckCircle,
        content = { navController, viewModel -> DetailsScreen(navController, viewModel) }
    )

    object Settings : MyNavDestination(
        route = "settings",
        title = R.string.settingsScreenTitle,
        label = R.string.settingsScreenLabel,
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        content = { navController, viewModel -> SettingsScreen(navController, viewModel) }
    )

    // FullScreens (benötigen keine Icons und kein Label;
    // dafür aber showArrowBack = true für den Zurück Pfeil in der TopBar

    object Screen1 : MyNavDestination(
        route = "other1",
        title = R.string.otherScreen1Title,
        showArrowBack = true,
        content = { navController, viewModel -> OtherScreen1(navController, viewModel) }
    )

    object Screen2 : MyNavDestination(
        route = "other2",
        title = R.string.otherScreen2Title,
        showArrowBack = true,
        content = { navController, viewModel -> OtherScreen2(navController, viewModel) }
    )

    // Dialog Screens

    object Info : MyNavDestination(
        route = "info",
        content = { navController, viewModel -> InfoScreen(navController, viewModel) }
    )

    object AlertDialog : MyNavDestination(
        route = "alert_dialog",
        content = { navController, viewModel -> AlertDialogScreen(navController, viewModel) }
    )
}


// Hier alle Bildschirme listen, über die in der Bottom Bar navigiert werden soll
val bottomBarNavDestinations = listOf (
    MyNavDestination.Home,
    MyNavDestination.Details,
    MyNavDestination.Settings,
)


// Hier alle Bildschirme listen, die als FullScreen Bildschirm angesprungen werden sollen
// wenn es keine gibt, dann
// val otherDestinations = emptyList<MyNavDestination>()
val otherDestinations = listOf (
    MyNavDestination.Screen1,
    MyNavDestination.Screen2
)


val navDestinations = bottomBarNavDestinations + otherDestinations


// Hier alle Dialogbilschirme listen
// wenn es keine gibt, dann
// val dialogDestinations = emptyList<MyNavDestination>()
val dialogDestinations = listOf (
    MyNavDestination.Info,
    MyNavDestination.AlertDialog
)

