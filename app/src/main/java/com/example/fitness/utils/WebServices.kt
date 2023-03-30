package com.example.fitness.utils

import com.example.fitness.models.SportResponse
import com.example.fitness.models.SportResponse1
import retrofit2.http.GET
import retrofit2.http.Path

interface WebServices {

    @GET("api/v1/sports")
    suspend fun getAllSports(): SportResponse

    @GET("api/v1/sports/{id}")
    suspend fun getSpecificSports(@Path("id")  id :String): SportResponse1


}