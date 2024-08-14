package edu.metrostate.myassignment1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import edu.metrostate.myassignment1.api.Request.updateUserTodo
import edu.metrostate.myassignment1.api.TodoManager
import edu.metrostate.myassignment1.api.TodoManager.setTodoList
import edu.metrostate.myassignment1.data.AddTodoResponse
import edu.metrostate.myassignment1.data.Meta
import edu.metrostate.myassignment1.data.UpdateTodo
import junit.framework.TestCase.assertTrue
import org.junit.Test

class TodoViewModelTest {

    private var _todoList = MutableLiveData<List<AddTodoResponse>>()
    val todoList : LiveData<List<AddTodoResponse>> = _todoList
    val item = "Run the tests"
    val index = 297

    @Test
    fun successfulTodoListFetchAndSet(){
        setTodoList()
        assert(
            todoList == TodoManager.getAllTodo()
        )
    }

    @Test
    fun failedTodoListFetchAndSet(){
        setTodoList()
        assert(
            todoList != TodoManager.getAllTodo()
        )
    }

    @Test
    fun successfullyAddingANewTodo(){
        TodoManager.addTodo(item)
        assertTrue(todoList.value!!.get(todoList.value!!.size).description ==  item)
    }

    @Test
    fun failAddingANewTodo(){
        TodoManager.addTodo(item)
        assertTrue(todoList.value!!.get(todoList.value!!.size).description !=  item)
    }

    @Test
    fun successfulldeleteTodo(){
        var success = false
        TodoManager.deleteTodo(index)
        for(item in todoList.value!!){
            if(item.id != index){
                success = true
            }
        }
        assert(success)
    }

    @Test
    fun failedfulldeleteTodo(){
        var success = true
        TodoManager.deleteTodo(index)
        for(item in todoList.value!!){
            if(item.id == index){
                success = false
            }
        }
        assert(success)
    }
}