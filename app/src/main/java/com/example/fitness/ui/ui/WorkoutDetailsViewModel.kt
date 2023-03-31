package com.example.fitness.ui.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitness.repositories.MainRepo
import com.example.fitness.ui.ui.add.SportState
import com.example.fitness.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutDetailsViewModel @Inject constructor(val mainRepo: MainRepo): ViewModel() {
    private val _state = MutableStateFlow<SportState>(SportState())
    val state = _state.asStateFlow()


    fun getSpecificSports(id:String) =viewModelScope.launch {
        mainRepo.getSpecificSports(id).collect{
            when(it){
                is Status.Loading->{
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Status.Success->{
                    _state.value = state.value.copy(
                        specificSport = it.data.data?.doc,
                        isLoading = false
                    )
                }
                is Status.Error->{
                    _state.value = state.value.copy(
                        isLoading = false,
                        error = it.message
                    )
                }
                else->{}
            }


        }
    }
}