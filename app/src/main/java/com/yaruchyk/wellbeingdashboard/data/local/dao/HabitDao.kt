package com.yaruchyk.wellbeingdashboard.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.yaruchyk.wellbeingdashboard.data.local.entity.HabitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @androidx.room.Transaction
    @Query("SELECT * FROM habits")
    fun getAllHabits(): Flow<List<com.yaruchyk.wellbeingdashboard.data.local.relation.HabitWithSchedules>>

    @Query("SELECT * FROM habits WHERE id = :id")
    suspend fun getHabitById(id: Int): HabitEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit(habit: HabitEntity): Long

    @Update
    suspend fun updateHabit(habit: HabitEntity)

    @Delete
    suspend fun deleteHabit(habit: HabitEntity)

    // Schedule methods
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchedules(schedules: List<com.yaruchyk.wellbeingdashboard.data.local.entity.HabitScheduleEntity>)

    @Query("DELETE FROM habit_schedules WHERE habitId = :habitId")
    suspend fun deleteSchedules(habitId: Int)

    @Query("SELECT dayOfWeek FROM habit_schedules WHERE habitId = :habitId")
    suspend fun getDaysForHabit(habitId: Int): List<Int>
}
