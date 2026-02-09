package com.yaruchyk.wellbeingdashboard.ui.stats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yaruchyk.wellbeingdashboard.presentation.viewmodel.StatisticsViewModel

@Composable
fun StatsScreen(
    viewModel: StatisticsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Resumen Semanal", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        if (uiState.isLoading) {
            CircularProgressIndicator()
        } else if (uiState.error != null) {
            Text(text = "Error: ${uiState.error}", color = MaterialTheme.colorScheme.error)
        } else if (uiState.stats != null) {
            val stats = uiState.stats!!

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Streak Card
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Racha Actual", style = MaterialTheme.typography.titleMedium)
                            Text(
                                text = "${stats.streak.currentStreak} días",
                                style = MaterialTheme.typography.displayMedium
                            )
                            Text(
                                "Máxima: ${stats.streak.maxStreak} días",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }

                // Habits Summary
                item {
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Hábitos Completados", style = MaterialTheme.typography.titleMedium)
                            Text(
                                text = "${stats.weeklyHabits.completedHabitsCount}",
                                style = MaterialTheme.typography.displaySmall
                            )
                            Text(
                                "Desde ${stats.weeklyHabits.startDate} hasta ${stats.weeklyHabits.endDate}",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }

                // Emotions Summary
                item {
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Emociones Registradas", style = MaterialTheme.typography.titleMedium)
                            if (stats.weeklyEmotions.dailyEmotions.isEmpty()) {
                                Text("No hay registros esta semana", style = MaterialTheme.typography.bodyMedium)
                            } else {
                                // Sort by date descending
                                val sortedDates = stats.weeklyEmotions.dailyEmotions.keys.sortedDescending()
                                sortedDates.forEach { date ->
                                    val emotionsList = stats.weeklyEmotions.dailyEmotions[date] ?: emptyList()
                                    Column(modifier = Modifier.padding(vertical = 4.dp)) {
                                        Text(
                                            text = date.toString(), // Or format nicely
                                            style = MaterialTheme.typography.labelMedium,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                        emotionsList.forEach { emotionString ->
                                            Text(
                                                text = "• $emotionString",
                                                style = MaterialTheme.typography.bodyMedium,
                                                modifier = Modifier.padding(start = 8.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
