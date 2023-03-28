package com.example.fitness.ui.ui.add


import com.example.fitness.models.Group


data class GroupState(
    val allGroups: List<Group>? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val success : String? = null
)
