package com.yaruchyk.wellbeingdashboard.di

import com.yaruchyk.wellbeingdashboard.data.repository.WellbeingRepositoryImpl
import com.yaruchyk.wellbeingdashboard.domain.repository.WellbeingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWellbeingRepository(
        wellbeingRepositoryImpl: WellbeingRepositoryImpl
    ): WellbeingRepository
}
