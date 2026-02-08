package com.yaruchyk.wellbeingdashboard.domain.model

import java.time.LocalDateTime

data class EmotionRecord(
    val id: Int = 0,
    val emotionType: String, // e.g., "Happy", "Sad", "Neutral"
    val intensity: EmotionIntensity,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val note: String? = null
)
