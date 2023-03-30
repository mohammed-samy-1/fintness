package com.example.fitness.ui.ui.add


import com.example.fitness.models.*


data class GroupState(
    val allGroups: List<Group> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val success : String? = null
)

data class SportState(
    val allSports: List<DataItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val success : String? = null,
    val specificSport : Doc ?=null
)
