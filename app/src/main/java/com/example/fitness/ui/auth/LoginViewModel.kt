package com.example.fitness.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitness.repositories.AuthRepo
import com.example.fitness.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() :ViewModel() {

    suspend fun login(email:String, password:String){
        viewModelScope.launch {
            authRepo.login(email, password).collect{
                when(it){
                    is Status.Loading ->{

                    }
                    is Status.Success<*> -> {

                    }
                    is Status.Error -> {

                    }
                }
            }
        }
    }

}