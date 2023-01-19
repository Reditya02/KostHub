package com.example.kosthub.di

import com.example.kosthub.data.Repository
import com.example.kosthub.data.locale.auth.AuthPreferences
import com.example.kosthub.data.remote.ApiService
import com.example.kosthub.data.repositoy.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ViewModelProvider {
    @Provides
    @Singleton
    fun provideRepository() = Repository()

    @Provides
    @Singleton
    fun provideAuthRepository(apiService: ApiService, preferences: AuthPreferences) = AuthRepository(apiService, preferences)
}