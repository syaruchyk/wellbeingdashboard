package com.yaruchyk.wellbeingdashboard.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector? = null) {
    object Dashboard : Screen("dashboard", "Inicio", Icons.Default.Home)
    object Habits : Screen("habits", "Hábitos", Icons.Default.CheckCircle)
    object Stats : Screen("stats", "Progreso", Icons.Default.BarChart)
    object Settings : Screen("settings", "Ajustes", Icons.Default.Settings)
}
