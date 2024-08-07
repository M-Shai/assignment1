package edu.metrostate.myassignment1.data

import com.squareup.moshi.Json

@Json(name = "admin")
data class TodoList(
    @Json(name = "TodoList")
    var TodoList: List<Todo>
)
