package com.yaruchyk.wellbeingdashboard.domain.repository

import com.yaruchyk.wellbeingdashboard.domain.model.EmotionRecord
import com.yaruchyk.wellbeingdashboard.domain.model.Habit
import kotlinx.coroutines.flow.Flow

interface WellbeingRepository {
    // Habits
    fun getAllHabits(): Flow<List<Habit>>
    suspend fun insertHabit(habit: Habit)
    suspend fun updateHabit(habit: Habit)
    suspend fun deleteHabit(habit: Habit)
    suspend fun getHabitById(id: Int): Habit?

    // Emotion Records
    fun getAllEmotionRecords(): Flow<List<EmotionRecord>>
    suspend fun insertEmotionRecord(record: EmotionRecord)
    suspend fun deleteEmotionRecord(record: EmotionRecord)
}
