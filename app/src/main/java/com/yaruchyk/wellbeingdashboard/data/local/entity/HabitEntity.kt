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
    fun toDomain(): Habit {
        return Habit(
            id = id,
            title = title,
            description = description,
            isActive = isActive
            // daysOfWeek is not part of the entity, handled by relations or defaulting to empty
        )
    }
}
