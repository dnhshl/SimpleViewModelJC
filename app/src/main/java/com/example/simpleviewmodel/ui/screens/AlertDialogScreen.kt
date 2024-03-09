package com.example.simpleviewmodel.ui.screens

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.simpleviewmodel.model.MainViewModel

@Composable
fun AlertDialogScreen(
    navController: NavController,
    viewModel: MainViewModel
) {

    AlertDialog(
        title = { Text("Info!") },
        text = { Text("Löschen oder nicht löschen, das ist hier die Frage.") },
        onDismissRequest = { navController.popBackStack() },
        confirmButton = {
            TextButton( onClick = { navController.popBackStack() } ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton( onClick = { navController.popBackStack() } ) {
                Text("Dismiss")
            }
        }
    )
}
