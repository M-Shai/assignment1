package edu.metrostate.myassignment1.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UpdateTodoResponse(
    @Json(name = "completed")
    val completed: Boolean,
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: Int
)