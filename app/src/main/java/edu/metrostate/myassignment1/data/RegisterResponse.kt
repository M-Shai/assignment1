package edu.metrostate.myassignment1.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegisterResponse(
    @Json(name = "admin")
    val admin: Boolean,
    @Json(name = "email")
    val email: String,
    @Json(name = "enabled")
    val enabled: Boolean,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "token")
    val token: String
)