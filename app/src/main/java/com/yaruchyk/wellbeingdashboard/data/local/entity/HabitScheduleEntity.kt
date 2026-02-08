package com.yaruchyk.wellbeingdashboard.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "habit_schedules",
    primaryKeys = ["habitId", "dayOfWeek"],
    foreignKeys = [
        ForeignKey(
            entity = HabitEntity::class,
            parentColumns = ["id"],
            childColumns = ["habitId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("habitId")]
)
data class HabitScheduleEntity(
    val habitId: Int,
    val dayOfWeek: Int // java.time.DayOfWeek value (1=Mon, 7=Sun)
)
