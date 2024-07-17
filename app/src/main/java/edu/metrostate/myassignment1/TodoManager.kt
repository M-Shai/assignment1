package edu.metrostate.myassignment1

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object TodoManager {

    private val todoList = mutableListOf<Todo>()
    private var index = mutableIntStateOf(5)

    fun getAllTodo() : List<Todo>{
        return todoList
    }

    fun addTodo(item: String){
        index = mutableIntStateOf(index.value + 1)
        todoList.add(Todo(index.value,item))
    }

    fun deleteTodo(index: Int){
        todoList.removeIf{
            it.index == index
        }
    }
}