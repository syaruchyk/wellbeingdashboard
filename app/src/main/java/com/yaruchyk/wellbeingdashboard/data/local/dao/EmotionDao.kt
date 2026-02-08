package com.yaruchyk.wellbeingdashboard.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yaruchyk.wellbeingdashboard.data.local.entity.EmotionRecordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EmotionDao {
    @Query("SELECT * FROM emotion_records ORDER BY timestamp DESC")
    fun getAllEmotionRecords(): Flow<List<EmotionRecordEntity>>

    @Query("SELECT * FROM emotion_records WHERE timestamp BETWEEN :start AND :end ORDER BY timestamp DESC")
    fun getEmotionRecordsBetween(start: java.time.LocalDateTime, end: java.time.LocalDateTime): Flow<List<EmotionRecordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmotionRecord(record: EmotionRecordEntity)

    @Delete
    suspend fun deleteEmotionRecord(record: EmotionRecordEntity)
}
