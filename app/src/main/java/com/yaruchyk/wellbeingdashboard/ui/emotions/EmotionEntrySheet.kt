package com.yaruchyk.wellbeingdashboard.ui.emotions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yaruchyk.wellbeingdashboard.domain.model.EmotionIntensity
import com.yaruchyk.wellbeingdashboard.presentation.viewmodel.EmotionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmotionEntrySheet(
    onDismiss: () -> Unit,
    viewModel: EmotionViewModel = hiltViewModel()
) {
    val sheetState = rememberModalBottomSheetState()
    val uiState by viewModel.uiState.collectAsState()

    // Plutchik simplified emotions
    val emotions = listOf("Alegría", "Tristeza", "Ira", "Miedo", "Confianza", "Asco", "Anticipación", "Sorpresa")

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()

        ) {
            Text(text = "¿Cómo te sientes?", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))

            // Error Message
            if (uiState.error != null) {
                Text(
                    text = uiState.error!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // Emotion Selector
            Text(text = "Emoción Principal", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            
            emotions.chunked(4).forEach { row ->
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    row.forEach { emotion ->
                        FilterChip(
                            selected = uiState.selectedEmotion == emotion,
                            onClick = { viewModel.updateEmotion(emotion) },
                            label = { Text(emotion) }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Intensity Selector
            Text(text = "Intensidad", style = MaterialTheme.typography.titleMedium)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                EmotionIntensity.entries.forEach { intensity ->
                    FilterChip(
                        selected = uiState.selectedIntensity == intensity,
                        onClick = { viewModel.updateIntensity(intensity) },
                        label = { Text(intensity.name) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Note Input
            OutlinedTextField(
                value = uiState.note,
                onValueChange = { viewModel.updateNote(it) },
                label = { Text("Nota (Opcional)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Save Button
            Button(
                onClick = {
                    viewModel.saveEmotion {
                        onDismiss()
                    }
                },
                enabled = uiState.selectedEmotion.isNotBlank() && uiState.selectedIntensity != null && !uiState.isSaving,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (uiState.isSaving) "Guardando..." else "Guardar Registro")
            }
            Spacer(modifier = Modifier.height(80.dp)) // Increased bottom padding to lift button
        }
    }
}
