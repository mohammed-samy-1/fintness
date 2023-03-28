package com.example.fitness.ui.ui.add


import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitness.models.Group
import com.example.fitness.repositories.MainRepo
import com.example.fitness.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val repo : MainRepo
) : ViewModel() {

    private val _stateGroup = MutableStateFlow(GroupState())
    val stateGroup = _stateGroup.asStateFlow()


    suspend fun upload(group: Group, uri: Uri)=viewModelScope.launch {
        repo.createGroup(group,uri).collect{
            when(it){
                is Status.Loading->{
                    _stateGroup.value = stateGroup.value.copy(
                        isLoading = true
                    )
                }
                is Status.Success->{
                    _stateGroup.value = stateGroup.value.copy(
                        isLoading = false,
                        success = "Group Created!"
                    )
                }
                is Status.Error->{
                    _stateGroup.value = stateGroup.value.copy(
                        isLoading = false,
                        error = "Something went wrong!"
                    )
                }
                else->{}
            }

        }
    }
}