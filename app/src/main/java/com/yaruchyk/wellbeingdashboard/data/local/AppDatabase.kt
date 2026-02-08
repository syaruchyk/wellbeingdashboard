package com.yaruchyk.wellbeingdashboard.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yaruchyk.wellbeingdashboard.data.local.dao.EmotionDao
import com.yaruchyk.wellbeingdashboard.data.local.dao.HabitDao
import com.yaruchyk.wellbeingdashboard.data.local.entity.EmotionRecordEntity
import com.yaruchyk.wellbeingdashboard.data.local.entity.HabitEntity

@Database(
    entities = [HabitEntity::class, EmotionRecordEntity::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
    abstract fun emotionDao(): EmotionDao
}
