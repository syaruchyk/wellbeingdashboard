package com.yaruchyk.wellbeingdashboard.domain.model

import java.time.LocalDateTime

data class EmotionRecord(
    val id: Int = 0,
    val emotionType: String, // e.g., "Happy", "Sad", "Neutral"
    val intensity: Int, // 1-5 or 1-10
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val note: String? = null
)
