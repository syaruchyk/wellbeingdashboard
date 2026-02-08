package com.yaruchyk.wellbeingdashboard.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaruchyk.wellbeingdashboard.domain.model.Habit
import com.yaruchyk.wellbeingdashboard.domain.repository.WellbeingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import javax.inject.Inject

@HiltViewModel
class HabitFormViewModel @Inject constructor(
    private val repository: WellbeingRepository
) : ViewModel() {

    fun saveHabit(
        title: String,
        description: String,
        days: Set<String>, // "L", "M", etc. needs mapping
        onSuccess: () -> Unit
    ) {
        if (title.isBlank()) return

        val daysMapped = mapDaysToDomain(days)

        viewModelScope.launch {
            repository.insertHabit(
                Habit(
                    title = title,
                    description = description,
                    daysOfWeek = daysMapped,
                    isActive = true
                )
            )
            onSuccess()
        }
    }

    private fun mapDaysToDomain(days: Set<String>): List<DayOfWeek> {
        val mapping = mapOf(
            "L" to DayOfWeek.MONDAY,
            "M" to DayOfWeek.TUESDAY,
            "X" to DayOfWeek.WEDNESDAY,
            "J" to DayOfWeek.THURSDAY,
            "V" to DayOfWeek.FRIDAY,
            "S" to DayOfWeek.SATURDAY,
            "D" to DayOfWeek.SUNDAY
        )
        return days.mapNotNull { mapping[it] }
    }
}
