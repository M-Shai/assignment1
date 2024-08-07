package edu.metrostate.myassignment1.api

import edu.metrostate.myassignment1.api.RetrofitInstance.retrofit
import edu.metrostate.myassignment1.data.LoginResponse
import edu.metrostate.myassignment1.data.User
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class Request1 {

    private val API_KEY = "ada98dfd-5d4b-416b-87f8-be5c22289016"
    val instance: Instance = Instance()

    fun login(
        email: String,
        password: String
    ): Response<LoginResponse> = runBlocking {
        var response: Response<LoginResponse>? = null
        val job = launch {
            val user = User(email, password)
            response = instance.retrofit.login(API_KEY, user);
        }

        job.join()

        if (response!!.isSuccessful) {
            println("success")
            println(response!!.body().toString())
            return@runBlocking response!!
        } else {
            println("failed")
            println(response!!.message())
            return@runBlocking response!!
        }
    }
}