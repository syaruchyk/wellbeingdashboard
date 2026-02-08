package com.yaruchyk.wellbeingdashboard.domain.model

import java.time.LocalDate

data class HabitCheck(
    val id: Int = 0,
    val habitId: Int,
    val date: LocalDate,
    val isCompleted: Boolean
)
