package com.yaruchyk.wellbeingdashboard.domain.model

import java.time.LocalDate

data class StreakStats(
    val currentStreak: Int = 0,
    val maxStreak: Int = 0
)

data class WeeklyHabitSummary(
    val startDate: LocalDate,
    val endDate: LocalDate,
    val completedHabitsCount: Int,
    val totalScheduledHabits: Int, // Context: how many *could* have been done
    val dailyCompletion: Map<LocalDate, Int> // Date -> Count
)

data class WeeklyEmotionSummary(
    val startDate: LocalDate,
    val endDate: LocalDate,
    val emotionCounts: Map<String, Int>, // EmotionType -> Count
    val intensityCounts: Map<EmotionIntensity, Int>,
    val dailyEmotions: Map<LocalDate, List<String>> // Date -> List of emotions
)

data class DashboardStats(
    val streak: StreakStats,
    val weeklyHabits: WeeklyHabitSummary,
    val weeklyEmotions: WeeklyEmotionSummary
)
