package edu.metrostate.myassignment1

import androidx.navigation.NavHostController
import edu.metrostate.myassignment1.models.HomeViewModel
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class HomeViewModelTest {
    private val hvm: HomeViewModel = HomeViewModel()
    private var navController: NavHostController = TODO()

    @Test
    fun loggingInWithGoodCredentials(){

        assertTrue(hvm.userLogin(
            "Ant@mail.com",
            "password",
            navController
        ))
    }

    @Test
    fun loggingInWithBadCredentials(){
        assertFalse(hvm.userLogin(
            "My@mail.com",
            "password1",
            navController
        ))
    }
}