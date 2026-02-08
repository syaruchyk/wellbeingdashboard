package com.yaruchyk.wellbeingdashboard.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yaruchyk.wellbeingdashboard.domain.model.Habit

@Entity(tableName = "habits")
data class HabitEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val isCompleted: Boolean
) {
    fun toDomain(): Habit {
        return Habit(
            id = id,
            title = title,
            description = description,
            isCompleted = isCompleted
        )
    }

    companion object {
        fun fromDomain(habit: Habit): HabitEntity {
            return HabitEntity(
                id = habit.id,
                title = habit.title,
                description = habit.description,
                isCompleted = habit.isCompleted
            )
        }
    }
}
