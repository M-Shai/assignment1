package edu.metrostate.myassignment1.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "enabled")
    val enabled: Int,
    @Json(name = "token")
    val token: String,
    @Json(name = "admin")
    val admin: Int,
    @Json(name = "warnings")
    val warnings: Int
)