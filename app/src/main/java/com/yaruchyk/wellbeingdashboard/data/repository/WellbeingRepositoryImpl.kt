package com.yaruchyk.wellbeingdashboard.data.repository

import com.yaruchyk.wellbeingdashboard.data.local.dao.EmotionDao
import com.yaruchyk.wellbeingdashboard.data.local.dao.HabitDao
import com.yaruchyk.wellbeingdashboard.data.local.entity.EmotionRecordEntity
import com.yaruchyk.wellbeingdashboard.data.local.entity.HabitEntity
import com.yaruchyk.wellbeingdashboard.domain.model.EmotionRecord
import com.yaruchyk.wellbeingdashboard.domain.model.Habit
import com.yaruchyk.wellbeingdashboard.domain.repository.WellbeingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WellbeingRepositoryImpl @Inject constructor(
    private val habitDao: HabitDao,
    private val emotionDao: EmotionDao
) : WellbeingRepository {

    // Habits
    override fun getAllHabits(): Flow<List<Habit>> {
        return habitDao.getAllHabits().map { relations ->
            relations.map { relation ->
                // Map Entity + Schedules -> Domain
                Habit(
                    id = relation.habit.id,
                    title = relation.habit.title,
                    description = relation.habit.description,
                    isActive = relation.habit.isActive,
                    daysOfWeek = relation.schedules.map { 
                        // Convert Int (1-7) to DayOfWeek
                        java.time.DayOfWeek.of(it.dayOfWeek) 
                    }
                )
            }
        }
    }

    override suspend fun insertHabit(habit: Habit) {
        val habitEntity = HabitEntity(
            id = habit.id, // 0 for new
            title = habit.title,
            description = habit.description,
            isActive = habit.isActive
        )
        // 1. Insert Habit
        val habitId = habitDao.insertHabit(habitEntity).toInt()
        
        // 2. Insert Schedules
        val scheduleEntities = habit.daysOfWeek.map { day ->
            com.yaruchyk.wellbeingdashboard.data.local.entity.HabitScheduleEntity(
                habitId = habitId,
                dayOfWeek = day.value
            )
        }
        // Replace schedules (delete old if update, but simpler to just replace relations if managing updates carefully)
        // For simple insert/update flow:
        if (habit.id != 0) {
            habitDao.deleteSchedules(habit.id)
        }
        habitDao.insertSchedules(scheduleEntities)
    }

    override suspend fun updateHabit(habit: Habit) {
        // Reuse insert logic since we handle ID and schedule replacement
        insertHabit(habit)
    }

    override suspend fun deleteHabit(habit: Habit) {
         // Cascade delete handles schedules
         val entity = HabitEntity(
            id = habit.id,
            title = habit.title,
            description = habit.description,
            isActive = habit.isActive
        )
        habitDao.deleteHabit(entity)
    }

    override suspend fun getHabitById(id: Int): Habit? {
        return habitDao.getHabitById(id)?.toDomain()
    }

    // Emotion Records
    override fun getAllEmotionRecords(): Flow<List<EmotionRecord>> {
        return emotionDao.getAllEmotionRecords().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun insertEmotionRecord(record: EmotionRecord) {
        emotionDao.insertEmotionRecord(EmotionRecordEntity.fromDomain(record))
    }

    override suspend fun deleteEmotionRecord(record: EmotionRecord) {
        emotionDao.deleteEmotionRecord(EmotionRecordEntity.fromDomain(record))
    }
}
