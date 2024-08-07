package edu.metrostate.myassignment1.models

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import edu.metrostate.myassignment1.data.LoginResponse
import edu.metrostate.myassignment1.data.RegisterResponse
import retrofit2.Response

object SharedViewModel: ViewModel() {
    lateinit var loggedInUser: LoginResponse
    lateinit var newUser: Response<RegisterResponse>
}