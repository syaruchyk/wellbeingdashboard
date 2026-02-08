package com.yaruchyk.wellbeingdashboard.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yaruchyk.wellbeingdashboard.domain.model.Habit

@Entity(tableName = "habits")
data class HabitEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String?,
    val isActive: Boolean = true,
    val createdAt: java.time.LocalDateTime = java.time.LocalDateTime.now()
) {
    // Adapter/Mapper logic will be handled in Repository to map partial data
}
