package com.example.fitness.repositories

import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepo @Inject constructor(mDatabase:FirebaseDatabase){
    suspend fun createGroup() = flow {
        emit("loading")
    }
}