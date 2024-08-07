package edu.metrostate.myassignment1.api

import edu.metrostate.myassignment1.api.RetrofitInstance.retrofit
import edu.metrostate.myassignment1.data.AddTodoResponse
import edu.metrostate.myassignment1.data.Credentials
import edu.metrostate.myassignment1.data.GetTodoResponse
import edu.metrostate.myassignment1.data.LoginResponse
import edu.metrostate.myassignment1.data.RegisterResponse
import edu.metrostate.myassignment1.data.Todo
import edu.metrostate.myassignment1.data.UpdateTodo
import edu.metrostate.myassignment1.data.UpdateTodoResponse
import edu.metrostate.myassignment1.data.User
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Response

object Request {

    private const val API_KEY = "ada98dfd-5d4b-416b-87f8-be5c22289016"

    fun login(
        email: String,
        password: String
    ): Response<LoginResponse> = runBlocking {
        println("Request 24")
        var response: Response<LoginResponse>? = null
        val job = launch {
            val user = User(email, password)
            println("Request 28")
            response = retrofit.login(API_KEY, user);
            println("Request 30")
        }

        job.join()

        if (response!!.isSuccessful) {
            println("Success 36: " + response!!.body())
            return@runBlocking response!!
        } else {
            println("failed 39: " + response!!.message())
            return@runBlocking response!!
        }
    }

    fun getUserTodos(userId: Int, token: String): Response<List<GetTodoResponse>> = runBlocking {
        println("Request 45")
        val auth = "Bearer $token"
        var response: Response<List<GetTodoResponse>>? = null
        val job = launch {
            println("Request 49: auth=$auth")
            response = retrofit.getUserTodos(auth, userId, API_KEY);
            println("Request 51")
        }

        job.join()
        println("Request 55")
        if (response!!.isSuccessful) {
            println("Request 57")
            println("Success: " + response!!.body())
            return@runBlocking response!!
        } else {
            println("Request 61")
            println("failed: " + response!!.message())
            return@runBlocking response!!
        }
    }

    fun addUserTodo(
        userId: Int,
        todo: Todo,
        token: String): Response<AddTodoResponse> = runBlocking {
        println("Request 71")
        val auth = "Bearer $token"
        var response: Response<AddTodoResponse>? = null
        val job = launch {
            println("Request 75: auth=$auth")
            response = retrofit.addUserTodo(auth, userId, API_KEY, todo);
            println("Request 77")
        }

        job.join()
        println("Request 81")
        if (response!!.isSuccessful) {
            println("Request 83")
            println("Success: " + response!!.body())
            return@runBlocking response!!
        } else {
            println("Request 87")
            println("failed: " + response!!.message())
            return@runBlocking response!!
        }
    }

    fun updateUserTodo(
        userId: Int,
        todoId: Int,
        todo: UpdateTodo,
        token: String): Response<UpdateTodoResponse> = runBlocking {
        println("Request 98")
        val auth = "Bearer $token"
        var response: Response<UpdateTodoResponse>? = null
        val job = launch {
            println("Request 102: auth=$auth")
            response = retrofit.updateTodo(auth, userId, todoId, API_KEY, todo);
            println("Request 104")
        }

        job.join()
        println("Request 108")
        if (response!!.isSuccessful) {
            println("Request 110")
            println("Success: " + response!!.body())
            return@runBlocking response!!
        } else {
            println("Request 114")
            println("failed: " + response!!.message())
            return@runBlocking response!!
        }
    }

    fun registerUser(
        user: Credentials): Response<RegisterResponse> = runBlocking {
        println("Request 122")
        var response: Response<RegisterResponse>? = null
        val job = launch {
            println("Request 125")
            response = retrofit.register(API_KEY, user);
            println("Request 127")
        }

        job.join()
        println("Request 131")
        if (response!!.isSuccessful) {
            println("Request 133")
            println("Success: " + response!!.body())
            return@runBlocking response!!
        } else {
            println("Request 137")
            println("failed: " + response!!.message())
            return@runBlocking response!!
        }
    }

}
