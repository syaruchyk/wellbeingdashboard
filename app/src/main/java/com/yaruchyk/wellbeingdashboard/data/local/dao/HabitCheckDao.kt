package com.yaruchyk.wellbeingdashboard.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yaruchyk.wellbeingdashboard.data.local.entity.HabitCheckEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface HabitCheckDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCheck(check: HabitCheckEntity)

    @Query("SELECT * FROM habit_checks WHERE habitId = :habitId AND date = :date")
    suspend fun getCheck(habitId: Int, date: LocalDate): HabitCheckEntity?

    @Query("SELECT * FROM habit_checks WHERE date = :date")
    fun getChecksForDate(date: LocalDate): Flow<List<HabitCheckEntity>>
}
