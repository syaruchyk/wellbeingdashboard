package com.yaruchyk.wellbeingdashboard.data.worker

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import dagger.hilt.android.qualifiers.ApplicationContext
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorkManagerScheduler @Inject constructor(
    @ApplicationContext private val context: Context
) {

    companion object {
        private const val WORK_NAME = "daily_reminder_work"
    }

    fun scheduleDailyReminder() {
        val now = LocalDateTime.now()
        val todayRefreshTime = now.with(LocalTime.of(21, 0)) // 21:00
        
        var scheduledTime = todayRefreshTime
        if (now.isAfter(todayRefreshTime)) {
            scheduledTime = todayRefreshTime.plusDays(1)
        }

        val initialDelay = Duration.between(now, scheduledTime).toMillis()

        val reminderRequest = PeriodicWorkRequestBuilder<DailyReminderWorker>(
            24, TimeUnit.HOURS
        )
            .setInitialDelay(initialDelay, TimeUnit.MILLISECONDS)
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            WORK_NAME,
            ExistingPeriodicWorkPolicy.UPDATE, // Update if exists to apply new delay if changed (though standard doesn't usually change)
            reminderRequest
        )
    }

    fun cancelDailyReminder() {
        WorkManager.getInstance(context).cancelUniqueWork(WORK_NAME)
    }
}
