package com.example.fitness.ui.ui.groups

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitness.repositories.MainRepo
import com.example.fitness.ui.ui.add.GroupState
import com.example.fitness.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroupsViewModel @Inject constructor(private var mainRepo: MainRepo) :ViewModel() {

    private val _stateGroup = MutableStateFlow(GroupState())
    val stateGroup = _stateGroup.asStateFlow()

    init {
        getAllGroups()
    }

    private fun getAllGroups() = viewModelScope.launch {
         mainRepo.getAllGroups().collect{
             when(it){
                 is Status.Loading->{
                     _stateGroup.value = stateGroup.value.copy(
                         isLoading = true
                     )
                 }
                 is Status.Success->{
                     _stateGroup.value = stateGroup.value.copy(
                         allGroups = it.data,
                         isLoading = false

                     )
                 }
                 is Status.Error->{
                        _stateGroup.value = stateGroup.value.copy(
                            isLoading = false,
                            error = it.message
                        )
                 }
                 else->{}
             }
         }
    }
}