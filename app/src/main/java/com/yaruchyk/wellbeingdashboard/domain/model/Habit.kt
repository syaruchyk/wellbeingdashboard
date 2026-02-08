package com.yaruchyk.wellbeingdashboard.domain.model

data class Habit(
    val id: Int = 0,
    val title: String,
    val description: String,
    val isCompleted: Boolean = false
)
