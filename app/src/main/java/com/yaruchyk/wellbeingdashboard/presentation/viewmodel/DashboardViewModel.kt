package com.yaruchyk.wellbeingdashboard.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaruchyk.wellbeingdashboard.domain.model.Habit
import com.yaruchyk.wellbeingdashboard.domain.repository.WellbeingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: WellbeingRepository
) : ViewModel() {

    // Filter habits for Today and combine with checks
    val todayHabits: StateFlow<List<com.yaruchyk.wellbeingdashboard.domain.model.HabitWithStatus>> =
        kotlinx.coroutines.flow.combine(
            repository.getAllHabits(),
            repository.getHabitChecksBetween(LocalDate.now(), LocalDate.now())
        ) { habits, checks ->
            val today = LocalDate.now().dayOfWeek
            val todayHabits = habits.filter { it.isActive && it.daysOfWeek.contains(today) }
            
            todayHabits.map { habit ->
                val isCompleted = checks.any { it.habitId == habit.id }
                com.yaruchyk.wellbeingdashboard.domain.model.HabitWithStatus(habit, isCompleted)
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun toggleHabitCompletion(habit: Habit, isCompleted: Boolean) {
        viewModelScope.launch {
            val date = LocalDate.now()
            if (isCompleted) {
                // Mark as completed
                repository.insertHabitCheck(
                    com.yaruchyk.wellbeingdashboard.domain.model.HabitCheck(
                        habitId = habit.id,
                        date = date,
                        isCompleted = true
                    )
                )
            } else {
                // Mark as not completed (delete check)
                repository.deleteHabitCheck(habit.id, date)
            }
        }
    }
}
