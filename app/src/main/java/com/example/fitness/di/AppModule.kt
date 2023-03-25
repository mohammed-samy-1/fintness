package com.example.fitness.di

import com.example.fitness.repositories.AuthRepo
import com.example.fitness.repositories.MainRepo
import com.google.firebase.database.FirebaseDatabase
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
    @Provides
    @Singleton
    fun MainRepo(mDatabase: FirebaseDatabase):AuthRepo{
        return MainRepo(mDatabase)
    }

    @Provides
    fun db():FirebaseDatabase{
        return FirebaseDatabase.getInstance()
    }
}