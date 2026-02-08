package com.yaruchyk.wellbeingdashboard.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaruchyk.wellbeingdashboard.domain.model.EmotionIntensity
import com.yaruchyk.wellbeingdashboard.domain.model.EmotionRecord
import com.yaruchyk.wellbeingdashboard.domain.repository.WellbeingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

data class EmotionUiState(
    val selectedEmotion: String = "",
    val selectedIntensity: EmotionIntensity? = null,
    val note: String = "",
    val isSaving: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class EmotionViewModel @Inject constructor(
    private val repository: WellbeingRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(EmotionUiState())
    val uiState: StateFlow<EmotionUiState> = _uiState.asStateFlow()

    fun updateEmotion(emotion: String) {
        _uiState.update { it.copy(selectedEmotion = emotion) }
    }

    fun updateIntensity(intensity: EmotionIntensity) {
        _uiState.update { it.copy(selectedIntensity = intensity) }
    }

    fun updateNote(note: String) {
        _uiState.update { it.copy(note = note) }
    }

    fun saveEmotion(onSuccess: () -> Unit) {
        val currentState = _uiState.value
        if (currentState.selectedEmotion.isBlank() || currentState.selectedIntensity == null) {
            _uiState.update { it.copy(error = "Emoción e Intensidad son obligatorias") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isSaving = true, error = null) }
            try {
                val record = EmotionRecord(
                    emotionType = currentState.selectedEmotion,
                    intensity = currentState.selectedIntensity,
                    timestamp = LocalDateTime.now(),
                    note = currentState.note.takeIf { it.isNotBlank() }
                )
                repository.insertEmotionRecord(record)
                // Reset state after save
                _uiState.update { EmotionUiState() }
                onSuccess()
            } catch (e: Exception) {
                _uiState.update { it.copy(isSaving = false, error = e.message) }
            }
        }
    }
}
