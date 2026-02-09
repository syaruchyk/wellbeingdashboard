package com.yaruchyk.wellbeingdashboard.domain.model

data class HabitWithStatus(
    val habit: Habit,
    val isCompleted: Boolean
)
