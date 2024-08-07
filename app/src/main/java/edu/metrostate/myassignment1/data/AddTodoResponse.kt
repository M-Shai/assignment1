package edu.metrostate.myassignment1.data

data class AddTodoResponse(
    val completed: Boolean,
    val description: String,
    val id: Int,
    val meta: MetaX
)