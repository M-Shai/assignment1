package edu.metrostate.myassignment1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel(){

    private var _todoList = MutableLiveData<List<Todo>>()
    val todoList : LiveData<List<Todo>> = _todoList

    private fun getAllTodo(){
        _todoList.value = TodoManager.getAllTodo()
    }

    fun addTodo(item: String){
        TodoManager.addTodo(item)
        getAllTodo()
    }

    fun deleteTodo(index: Int){
        TodoManager.deleteTodo(index)
        getAllTodo()
    }
}