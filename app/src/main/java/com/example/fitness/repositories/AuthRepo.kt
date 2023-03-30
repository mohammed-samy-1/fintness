package com.example.fitness.repositories

import com.example.fitness.models.User
import com.example.fitness.utils.Status
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepo @Inject constructor(val auth: FirebaseAuth, val mDatabase: FirebaseDatabase) {
    suspend fun signUp(user: User, password: String) = flow {
        emit(Status.Loading)
        try {
            val t = auth.createUserWithEmailAndPassword(user.email, password)
            t.await()
            if (t.isSuccessful) {
                auth.currentUser?.uid?.let { user.id = it }
                val createTask = mDatabase.getReference("users")
                    .child(user.id).setValue(user)
                createTask.await()
                if (createTask.isSuccessful)
                    emit(Status.Success("created account successfully"))
            }
        } catch (e: FirebaseException) {
            e.localizedMessage?.let {
                emit(Status.Error(it))
            }
        }
    }.flowOn(Dispatchers.IO)

    suspend fun login(email:String , password: String) = flow {
        emit(Status.Loading)
        try {
            val task = auth.signInWithEmailAndPassword(email, password)
            task.await()
            if (task .isSuccessful){
                emit(Status.Success("logged in successfully"))
            }
        }catch (e:FirebaseAuthException){
            e.localizedMessage?.let { emit(it) }
        }
    }.flowOn(Dispatchers.IO)

}