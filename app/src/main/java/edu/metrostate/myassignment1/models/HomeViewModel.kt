package edu.metrostate.myassignment1.models

import androidx.lifecycle.ViewModel
import edu.metrostate.myassignment1.api.Request.login
import edu.metrostate.myassignment1.data.LoginResponse
import retrofit2.Response

class HomeViewModel : ViewModel() {
    //private val request: Request1 = Request1()
    fun userLogin(email: String, password: String) {
        val response: Response<LoginResponse> = login(
            email,
            password
        )
        println("HVM Line 15")
        val user = response.body()
        println("HVM Line 17")
        println(user)

    }
}

