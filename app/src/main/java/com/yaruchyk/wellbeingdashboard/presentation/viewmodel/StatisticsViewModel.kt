package com.yaruchyk.wellbeingdashboard.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaruchyk.wellbeingdashboard.domain.model.DashboardStats
import com.yaruchyk.wellbeingdashboard.domain.usecase.GetWeeklyStatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

data class StatsUiState(
    val isLoading: Boolean = false,
    val stats: DashboardStats? = null,
    val error: String? = null
)

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    private val getWeeklyStatsUseCase: GetWeeklyStatsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(StatsUiState())
    val uiState: StateFlow<StatsUiState> = _uiState.asStateFlow()

    init {
        loadStats()
    }

    fun loadStats() {
        viewModelScope.launch {
            getWeeklyStatsUseCase()
                .onStart { _uiState.value = StatsUiState(isLoading = true) }
                .catch { e -> _uiState.value = StatsUiState(error = e.message) }
                .collect { stats ->
                    _uiState.value = StatsUiState(stats = stats)
                }
        }
    }
}
