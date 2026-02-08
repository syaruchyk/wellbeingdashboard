package com.yaruchyk.wellbeingdashboard.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yaruchyk.wellbeingdashboard.ui.components.BottomNavBar
import com.yaruchyk.wellbeingdashboard.ui.dashboard.DashboardScreen
import com.yaruchyk.wellbeingdashboard.ui.habits.HabitsScreen
import com.yaruchyk.wellbeingdashboard.ui.habits.HabitFormScreen
import com.yaruchyk.wellbeingdashboard.ui.navigation.Screen
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Dashboard.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Dashboard.route) {
                DashboardScreen(navController)
            }
            composable(Screen.Habits.route) {
                HabitsScreen(navController)
            }
            composable(Screen.HabitForm.route) {
                HabitFormScreen(navController)
            }
            composable(Screen.Stats.route) {
                PlaceholderScreen("Estadísticas y Progreso")
            }
            composable(Screen.Settings.route) {
                PlaceholderScreen("Ajustes")
            }
        }
    }
}

@Composable
fun PlaceholderScreen(title: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = title)
    }
}
