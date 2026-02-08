package com.yaruchyk.wellbeingdashboard.domain.usecase

import com.yaruchyk.wellbeingdashboard.data.repository.SettingsRepository
import com.yaruchyk.wellbeingdashboard.data.worker.WorkManagerScheduler
import javax.inject.Inject

class ToggleReminderUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository,
    private val scheduler: WorkManagerScheduler
) {
    suspend operator fun invoke(enabled: Boolean) {
        settingsRepository.setNotificationEnabled(enabled)
        if (enabled) {
            scheduler.scheduleDailyReminder()
        } else {
            scheduler.cancelDailyReminder()
        }
    }
}
