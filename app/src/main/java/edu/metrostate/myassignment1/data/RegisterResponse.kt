package edu.metrostate.myassignment1.data

data class RegisterResponse(
    val admin: Boolean,
    val email: String,
    val enabled: Boolean,
    val id: Int,
    val name: String,
    val token: String
)