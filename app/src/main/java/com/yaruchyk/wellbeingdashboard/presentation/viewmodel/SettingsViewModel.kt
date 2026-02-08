package com.yaruchyk.wellbeingdashboard.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaruchyk.wellbeingdashboard.data.repository.SettingsRepository
import com.yaruchyk.wellbeingdashboard.domain.usecase.ToggleReminderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    settingsRepository: SettingsRepository,
    private val toggleReminderUseCase: ToggleReminderUseCase
) : ViewModel() {

    val isNotificationEnabled: StateFlow<Boolean> = settingsRepository.isNotificationEnabled
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    fun toggleNotification(enabled: Boolean) {
        viewModelScope.launch {
            toggleReminderUseCase(enabled)
        }
    }
}
