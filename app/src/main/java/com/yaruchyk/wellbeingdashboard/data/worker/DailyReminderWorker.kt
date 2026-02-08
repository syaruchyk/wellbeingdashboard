package com.yaruchyk.wellbeingdashboard.data.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.yaruchyk.wellbeingdashboard.ui.notifications.NotificationHelper
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

class DailyReminderWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface DailyReminderWorkerEntryPoint {
        fun getNotificationHelper(): NotificationHelper
    }

    override fun doWork(): Result {
        val appContext = applicationContext
        val entryPoint = EntryPointAccessors.fromApplication(
            appContext,
            DailyReminderWorkerEntryPoint::class.java
        )
        val notificationHelper = entryPoint.getNotificationHelper()

        // We could check preferences here again, but usually scheduling logic handles it.
        // For robustness, if we want to double check enabled state, we'd need SettingsRepository too.
        // For simple MVP: if it's scheduled, it runs. logic to cancel is in scheduler.
        
        notificationHelper.showDailyReminder()

        return Result.success()
    }
}
