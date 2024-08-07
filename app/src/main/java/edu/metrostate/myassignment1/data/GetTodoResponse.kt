package edu.metrostate.myassignment1.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetTodoResponse(
    @Json(name = "author")
    val author: String,
    @Json(name = "completed")
    val completed: Int,
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "meta")
    val meta: Meta? = null,
    @Json(name = "user_id")
    val user_id: Int
)