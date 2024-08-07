package edu.metrostate.myassignment1.api

import androidx.compose.runtime.mutableIntStateOf
import edu.metrostate.myassignment1.data.Todo
import edu.metrostate.myassignment1.misc.ToDo

object TodoManager {

    private val todoList = mutableListOf<ToDo>()
    private var index = mutableIntStateOf(5)

    fun getAllTodo() : List<ToDo>{
        return todoList
    }

    fun addTodo(item: String){
        index = mutableIntStateOf(index.value + 1)
        todoList.add(ToDo(index.value,item))
    }

    fun deleteTodo(index: Int){
        todoList.removeIf{
            it.index == index
        }
    }

}