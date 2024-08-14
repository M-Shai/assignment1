package edu.metrostate.myassignment1.models

import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import edu.metrostate.myassignment1.Screen
import edu.metrostate.myassignment1.api.Request.getUserTodos
import edu.metrostate.myassignment1.api.Request.updateUserTodo
import edu.metrostate.myassignment1.api.RetrofitInstance.retrofit
import edu.metrostate.myassignment1.api.TodoManager
import edu.metrostate.myassignment1.api.TodoManager.setTodoList
import edu.metrostate.myassignment1.data.AddTodoResponse
import edu.metrostate.myassignment1.data.Todo
import edu.metrostate.myassignment1.data.TodoList
import edu.metrostate.myassignment1.data.UpdateTodo
import edu.metrostate.myassignment1.models.SharedViewModel.loggedInUser

class TodoViewModel() : ViewModel(){

    private var _todoList = MutableLiveData<List<AddTodoResponse>>()
    val todoList : LiveData<List<AddTodoResponse>> = _todoList

    fun setAllTodo(){
        //setTodoList()
        println("TVM 20")
        _todoList.value = TodoManager.getAllTodo()
        println("TVM 22")

    }

    fun addTodo(item: String){
        TodoManager.addTodo(item)
        setAllTodo()
    }

    fun deleteTodo(index: Int){
        TodoManager.deleteTodo(index)
        setAllTodo()
    }

    fun returnToHome(navController: NavController){
        navController.navigate(Screen.Home.route)
    }


    fun updateThisTodo(uid: Int, todoId: Int, todo: AddTodoResponse, token: String){
        var updateTodo = UpdateTodo(todo.completed, todo.description)
        updateUserTodo(uid, todoId, updateTodo, token)

    }
}