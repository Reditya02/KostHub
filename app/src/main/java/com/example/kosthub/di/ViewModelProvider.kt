package com.example.kosthub.di

import com.example.kosthub.data.locale.auth.AuthPreferences
import com.example.kosthub.data.remote.ApiService
import com.example.kosthub.data.repositoy.KostRoomRepository
import com.example.kosthub.data.repositoy.TransactionRepository
import com.example.kosthub.data.repositoy.UserRepository
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
    fun provideUserRepository(apiService: ApiService, preferences: AuthPreferences) = UserRepository(apiService, preferences)

    @Provides
    @Singleton
    fun provideKostRoomRepository(apiService: ApiService, preferences: AuthPreferences) = KostRoomRepository(apiService, preferences)

    @Provides
    @Singleton
    fun provideTransactionRepository(apiService: ApiService, preferences: AuthPreferences) = TransactionRepository(apiService, preferences)
}