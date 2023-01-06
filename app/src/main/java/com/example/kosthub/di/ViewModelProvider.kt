package com.example.kosthub.di

import com.example.kosthub.data.Repository
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
}