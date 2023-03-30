package com.example.fitness.models

import com.google.gson.annotations.SerializedName

data class SportResponse1(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Data(

	@field:SerializedName("doc")
	val doc: Doc? = null
)

data class Doc(

	@field:SerializedName("diffculty")
	val diffculty: String? = null,

	@field:SerializedName("__v")
	val v: Int? = null,

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
	val steps: List<String>
):java.io.Serializable
