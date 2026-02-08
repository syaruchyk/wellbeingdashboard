package com.yaruchyk.wellbeingdashboard.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yaruchyk.wellbeingdashboard.domain.model.EmotionRecord
import java.time.LocalDateTime

@Entity(tableName = "emotion_records")
data class EmotionRecordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val emotionType: String,
    val intensity: Int,
    val timestamp: LocalDateTime,
    val note: String?
) {
    fun toDomain(): EmotionRecord {
        return EmotionRecord(
            id = id,
            emotionType = emotionType,
            intensity = intensity,
            timestamp = timestamp,
            note = note
        )
    }

    companion object {
        fun fromDomain(record: EmotionRecord): EmotionRecordEntity {
            return EmotionRecordEntity(
                id = record.id,
                emotionType = record.emotionType,
                intensity = record.intensity,
                timestamp = record.timestamp,
                note = record.note
            )
        }
    }
}
