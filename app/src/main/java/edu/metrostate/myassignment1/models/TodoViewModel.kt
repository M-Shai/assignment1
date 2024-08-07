package edu.metrostate.myassignment1.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.metrostate.myassignment1.api.TodoManager
import edu.metrostate.myassignment1.data.Todo

class TodoViewModel : ViewModel(){

    private var _todoList = MutableLiveData<List<Todo>>()
    val todoList : LiveData<List<Todo>> = _todoList

    private fun getAllTodo(){
        //_todoList.value = TodoManager.getAllTodo()
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