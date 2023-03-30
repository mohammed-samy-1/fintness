package com.example.fitness.repositories

import android.net.Uri
import com.example.fitness.models.Group
import com.example.fitness.utils.Status
import com.example.fitness.utils.WebServices
import com.google.firebase.FirebaseException
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class MainRepo @Inject constructor(val mDatabase: FirebaseDatabase, val mStorage: FirebaseStorage,  private val webServices: WebServices) {
    suspend fun createGroup(group: Group, uri: Uri) = flow {
        emit(Status.Loading)
        try {
            val imgRef = mStorage.getReference("images/groups/${group.id}")
            imgRef.putFile(uri).await()
            group.image = imgRef.downloadUrl.await().toString()
            val addToFirebase = mDatabase.getReference("groups/${group.id}").setValue(group)
            addToFirebase.await()
            if (addToFirebase.isSuccessful) {
                emit(Status.Success("Group Created!"))
            } else {
                emit(Status.Error("Something went wrong!"))
            }
        } catch (e: FirebaseException) {
            emit(e.localizedMessage?.let { Status.Error(it) })
        }
    }

    suspend fun getAllGroups() = flow {
        emit(Status.Loading)
        try {
            val ref = mDatabase.getReference("groups")
            val groups = ref.get().await()
            val list = mutableListOf<Group>()
            for (child in groups.children){
                child.getValue(Group::class.java)?.let {list.add(it) }
            }
            emit(Status.Success(list))
        } catch (e: FirebaseException) {
            emit(Status.Error(e.message.toString()))
        }
    }

    suspend fun getAllSports()= flow {
        emit(Status.Loading)
        try {
            val response = webServices.getAllSports()
            emit(Status.Success(response))
        }catch (e:Exception){
            emit(Status.Error(e.message.toString()))
        }

    }

    suspend fun getSpecificSports(id:String)= flow {
        emit(Status.Loading)
        try {
            val response = webServices.getSpecificSports(id)
            emit(Status.Success(response))
        }catch (e:Exception){
            emit(Status.Error(e.message.toString()))
        }

    }
}