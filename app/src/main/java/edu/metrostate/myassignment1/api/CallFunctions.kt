package edu.metrostate.myassignment1.api

import edu.metrostate.myassignment1.data.Todo
import edu.metrostate.myassignment1.data.User
import kotlinx.coroutines.flow.Flow


interface CallFunctions {
    suspend fun getTodoList(): Flow<Result<List<Todo>>>
    suspend fun Login(): Flow<Result<Results<User>>>
    suspend fun register(): Flow<Result<Results<User>>>
    suspend fun addTodo(): Flow<Result<List<Todo>>>
    suspend fun checkOffTodo(): Flow<Result<List<Todo>>>
}