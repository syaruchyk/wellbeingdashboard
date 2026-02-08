package com.yaruchyk.wellbeingdashboard.data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.yaruchyk.wellbeingdashboard.data.local.entity.HabitEntity
import com.yaruchyk.wellbeingdashboard.data.local.entity.HabitScheduleEntity

data class HabitWithSchedules(
    @Embedded val habit: HabitEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "habitId"
    )
    val schedules: List<HabitScheduleEntity>
)
