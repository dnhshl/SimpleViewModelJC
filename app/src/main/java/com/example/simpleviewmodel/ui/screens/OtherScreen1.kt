package com.example.simpleviewmodel.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.simpleviewmodel.model.MainViewModel
import com.example.simpleviewmodel.ui.navigation.MyNavDestination


@Composable
fun OtherScreen1(
    navController: NavController,
    viewModel: MainViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Other Screen 1", fontSize =  24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate(MyNavDestination.Screen2.route) }) {
            Text("go to full screen 2")
        }
    }
}
