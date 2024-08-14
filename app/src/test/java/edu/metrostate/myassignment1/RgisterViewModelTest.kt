package edu.metrostate.myassignment1

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import edu.metrostate.myassignment1.api.Request.registerUser
import edu.metrostate.myassignment1.data.Credentials
import edu.metrostate.myassignment1.models.HomeViewModel
import edu.metrostate.myassignment1.models.RegisterViewModel
import edu.metrostate.myassignment1.models.SharedViewModel.newUser
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class RegisterViewModelTest {
    private val rvm: RegisterViewModel = RegisterViewModel()
    private var navController: NavHostController = TODO()

    @Test
    fun registeringWithNewUserData(){

        assertTrue(rvm.registerNewUser(
            navController,
            "Kat",
            "Kat@mail.com",
            "p3" ))
    }

    @Test
    fun registeringWithAlreadyRegisteredUserCredentials(){
        assertFalse(rvm.registerNewUser(
            navController,
            "Kat",
            "Kat@mail.com",
            "" ))
    }
}