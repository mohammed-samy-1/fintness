package com.example.fitness.di

import com.example.fitness.repositories.AuthRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun authRepo():AuthRepo{
        return AuthRepo()
    }
}