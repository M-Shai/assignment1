package edu.metrostate.myassignment1.models

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import edu.metrostate.myassignment1.Screen
import edu.metrostate.myassignment1.api.Request.registerUser
import edu.metrostate.myassignment1.data.Credentials
import edu.metrostate.myassignment1.models.SharedViewModel.newUser

class RegisterViewModel() : ViewModel() {
    private var name: String? = null
    private var email: String? = null
    private var password: String? = null

    fun registerNewUser(
        navController: NavController,
        name: String,
        email: String,
        password: String){
        println("RegisterViewModel 20")
        var userCred = Credentials(name,email,password)
        println("RegisterViewModel 22: $userCred")
        val registerResponse = registerUser(userCred)
        println("RegisterViewModel 24: ${registerResponse.body()}")
        if(userCred != null){
            newUser = registerResponse
            println("RegisterViewModel 27")
            navController.navigate(Screen.Home.route)
        }
    }

    fun returnLogin(navController: NavController){
        navController.navigate(Screen.Home.route)
    }

}