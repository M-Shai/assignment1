package edu.metrostate.myassignment1.api

import androidx.compose.runtime.mutableIntStateOf
import edu.metrostate.myassignment1.api.Request.addUserTodo
import edu.metrostate.myassignment1.api.Request.getUserTodos
import edu.metrostate.myassignment1.api.RetrofitInstance.retrofit
import edu.metrostate.myassignment1.data.AddTodoResponse
import edu.metrostate.myassignment1.data.Meta
import edu.metrostate.myassignment1.data.Todo
import edu.metrostate.myassignment1.misc.ToDo
import edu.metrostate.myassignment1.models.SharedViewModel.loggedInUser

object TodoManager {

    private var todoList = mutableListOf<AddTodoResponse>()
    //private var index = mutableIntStateOf(0)

    fun getAllTodo() : List<AddTodoResponse>{
        setTodoList()
        return todoList
    }

    fun addTodo(item: String){
        //index = mutableIntStateOf(index.value + 1)

        var todoResponse = addUserTodo(
            loggedInUser.id,
            Todo(false, item, Meta()),
            loggedInUser.token).body()

        if (todoResponse != null) {
            todoList.add(todoResponse)
        }
    }

    fun deleteTodo(index: Int){
        /*
        todoList.removeIf{
            it.index == index
        }

         */
    }
    fun setTodoList(){
        println("TodoManager 34")
        todoList = getUserTodos(
            loggedInUser.id,
            loggedInUser.token).body() as MutableList<AddTodoResponse>
        println("TodoManager 36")
    }

}