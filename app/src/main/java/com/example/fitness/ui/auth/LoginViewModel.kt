package com.example.fitness.ui.auth

import androidx.lifecycle.ViewModel
import com.example.fitness.repositories.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepo: AuthRepo) :ViewModel() {

}