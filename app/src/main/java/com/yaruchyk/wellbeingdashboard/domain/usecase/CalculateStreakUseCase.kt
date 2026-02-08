package com.yaruchyk.wellbeingdashboard.domain.usecase

import com.yaruchyk.wellbeingdashboard.domain.model.StreakStats
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import javax.inject.Inject

class CalculateStreakUseCase @Inject constructor() {

    operator fun invoke(completedDates: List<LocalDate>, referenceDate: LocalDate = LocalDate.now()): StreakStats {
        if (completedDates.isEmpty()) return StreakStats()

        val sortedDates = completedDates.distinct().sorted()
        
        // Max Streak
        var maxStreak = 0
        var currentSequence = 0
        if (sortedDates.isNotEmpty()) {
            currentSequence = 1
            maxStreak = 1
            for (i in 0 until sortedDates.size - 1) {
                val current = sortedDates[i]
                val next = sortedDates[i + 1]
                if (ChronoUnit.DAYS.between(current, next) == 1L) {
                    currentSequence++
                } else {
                    currentSequence = 1
                }
                if (currentSequence > maxStreak) {
                    maxStreak = currentSequence
                }
            }
        }

        // Current Streak
        // Count backwards from referenceDate.
        // If referenceDate is completed, streak includes it.
        // If referenceDate is NOT completed, but referenceDate-1 IS, streak continues.
        // If referenceDate-1 is NOT, streak is 0 (or 1 if today is done).
        
        var currentStreak = 0
        val todayDone = sortedDates.contains(referenceDate)
        var checkDate = if (todayDone) referenceDate else referenceDate.minusDays(1)
        
        while (sortedDates.contains(checkDate)) {
            currentStreak++
            checkDate = checkDate.minusDays(1)
        }

        return StreakStats(
            currentStreak = currentStreak,
            maxStreak = maxStreak
        )
    }
}
