package edu.metrostate.myassignment1.models

import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import edu.metrostate.myassignment1.Screen
import edu.metrostate.myassignment1.api.Request.login
import edu.metrostate.myassignment1.api.TodoManager.setTodoList
import edu.metrostate.myassignment1.data.LoginResponse
import retrofit2.Response
import edu.metrostate.myassignment1.models.SharedViewModel
import edu.metrostate.myassignment1.models.SharedViewModel.loggedInUser

class HomeViewModel() : ViewModel() {
    //private val request: Request1 = Request1()
    fun userLogin(email: String, password: String, navController: NavController) {
        val response: Response<LoginResponse> = login(
            email,
            password
        )
        println("HVM Line 22")
        val user = response.body()
        println("HVM Line 24")
        println("Error: " + response.message())
        println(user)
        if(user != null){
            println("HVM Line 28")
            loggedInUser = user
            println("HVM Line 30")
            setTodoList()
            println("HVM Line 32")
            navController.navigate(Screen.Todo.route)
        }

    }
}

