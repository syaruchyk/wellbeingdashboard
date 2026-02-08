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
        return habitDao.getAllHabits().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun insertHabit(habit: Habit) {
        habitDao.insertHabit(HabitEntity.fromDomain(habit))
    }

    override suspend fun updateHabit(habit: Habit) {
        habitDao.updateHabit(HabitEntity.fromDomain(habit))
    }

    override suspend fun deleteHabit(habit: Habit) {
        habitDao.deleteHabit(HabitEntity.fromDomain(habit))
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
