package com.example.fitness.ui.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
class DashboardViewModel @Inject constructor(val mainRepo: MainRepo ) : ViewModel() {

    private val _state = MutableStateFlow<SportState>(SportState())
    val state = _state.asStateFlow()

    init {
        getAllSports()
    }
    private  fun getAllSports() = viewModelScope.launch {
        mainRepo.getAllSports().collect{
            when(it){
                is Status.Loading->{
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Status.Success->{
                    _state.value = state.value.copy(
                        allSports = it.data.data!!,
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