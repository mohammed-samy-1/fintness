package com.example.fitness.models

import com.google.gson.annotations.SerializedName

data class SportResponse(

	@field:SerializedName("result")
	val result: String? = null,

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DataItem(

	@field:SerializedName("diffculty")
	val diffculty: String? = null,

	@field:SerializedName("colories")
	val colories: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("steps")
	val steps: List<String?>? = null
):java.io.Serializable
