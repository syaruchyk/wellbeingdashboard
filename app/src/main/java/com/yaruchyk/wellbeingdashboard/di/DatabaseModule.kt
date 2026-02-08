package com.yaruchyk.wellbeingdashboard.di

import android.content.Context
import androidx.room.Room
import com.yaruchyk.wellbeingdashboard.data.local.AppDatabase
import com.yaruchyk.wellbeingdashboard.data.local.dao.EmotionDao
import com.yaruchyk.wellbeingdashboard.data.local.dao.HabitDao
import com.yaruchyk.wellbeingdashboard.data.repository.WellbeingRepositoryImpl
import com.yaruchyk.wellbeingdashboard.domain.repository.WellbeingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "wellbeing_database"
        ).build()
    }

    @Provides
    fun provideHabitDao(database: AppDatabase): HabitDao {
        return database.habitDao()
    }

    @Provides
    fun provideEmotionDao(database: AppDatabase): EmotionDao {
        return database.emotionDao()
    }

    @Provides
    @Singleton
    fun provideWellbeingRepository(
        habitDao: HabitDao,
        emotionDao: EmotionDao
    ): WellbeingRepository {
        return WellbeingRepositoryImpl(habitDao, emotionDao)
    }
}
