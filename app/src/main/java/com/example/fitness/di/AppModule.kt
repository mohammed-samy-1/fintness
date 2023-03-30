package com.example.fitness.di

import com.example.fitness.repositories.AuthRepo
import com.example.fitness.repositories.MainRepo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
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
    fun authRepo(auth: FirebaseAuth , mDatabase: FirebaseDatabase):AuthRepo{
        return AuthRepo(auth , mDatabase)
    }
    @Provides
    @Singleton
    fun MainRepo(mDatabase: FirebaseDatabase, mStorage: FirebaseStorage):MainRepo{
        return MainRepo(mDatabase, mStorage)
    }

    @Provides
    fun db():FirebaseDatabase{
        return FirebaseDatabase.getInstance()
    }
    @Provides
    fun storage():FirebaseStorage{
        return FirebaseStorage.getInstance()
    }
    @Provides
    fun auth():FirebaseAuth{
        return FirebaseAuth.getInstance()
    }
}