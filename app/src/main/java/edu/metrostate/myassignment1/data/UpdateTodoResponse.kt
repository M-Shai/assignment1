package edu.metrostate.myassignment1.data

data class UpdateTodoResponse(
    val completed: Boolean,
    val description: String,
    val id: Int
)