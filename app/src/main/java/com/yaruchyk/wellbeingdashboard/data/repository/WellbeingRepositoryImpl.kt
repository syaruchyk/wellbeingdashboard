package com.yaruchyk.wellbeingdashboard.data.repository

import com.yaruchyk.wellbeingdashboard.data.local.dao.EmotionDao
import com.yaruchyk.wellbeingdashboard.data.local.dao.HabitDao
import com.yaruchyk.wellbeingdashboard.data.local.dao.HabitCheckDao
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
    private val habitCheckDao: HabitCheckDao,
    private val emotionDao: EmotionDao
) : WellbeingRepository {

    // ... (existing methods kept same by not touching them in replacement if possible, but I need to replace class header and new methods)
    // To avoid replacing whole file, I will do it in chunks.
    // Chunk 1: Constructor
    // Chunk 2: New Methods
    
    // Actually, let's just do the whole file or large chunks.
    // I'll start with constructor.
    
    // Wait, the tool requires contiguous blocks.
    // I will use replace_file_content for constructor and then another for methods?
    // Or just one big replace if they are close? They are at opposite ends.
    // I'll use separate calls or multi_replace.
    // Let's use multi_replace.


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

    override fun getHabitChecksBetween(
        startDate: java.time.LocalDate,
        endDate: java.time.LocalDate
    ): Flow<List<com.yaruchyk.wellbeingdashboard.domain.model.HabitCheck>> {
        return habitCheckDao.getChecksBetween(startDate, endDate).map { entities ->
            entities.map { entity ->
                com.yaruchyk.wellbeingdashboard.domain.model.HabitCheck(
                    id = entity.id,
                    habitId = entity.habitId,
                    date = entity.date,
                    isCompleted = entity.isCompleted
                )
            }
        }
    }

    override suspend fun insertHabitCheck(check: com.yaruchyk.wellbeingdashboard.domain.model.HabitCheck) {
        habitCheckDao.insertCheck(
            com.yaruchyk.wellbeingdashboard.data.local.entity.HabitCheckEntity(
                id = check.id,
                habitId = check.habitId,
                date = check.date,
                isCompleted = check.isCompleted
            )
        )
    }

    override suspend fun deleteHabitCheck(habitId: Int, date: java.time.LocalDate) {
        habitCheckDao.deleteCheck(habitId, date)
    }

    override fun getEmotionRecordsBetween(
        start: java.time.LocalDateTime,
        end: java.time.LocalDateTime
    ): Flow<List<EmotionRecord>> {
        return emotionDao.getEmotionRecordsBetween(start, end).map { entities ->
            entities.map { it.toDomain() }
        }
    }
}
