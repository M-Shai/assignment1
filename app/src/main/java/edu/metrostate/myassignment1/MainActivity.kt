package edu.metrostate.myassignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "Login") {
                composable("Login") {
                    Login() {
                        navController.navigate("Register")
                        // TodoView(viewModel = todoViewModel)
                    }
                }
                composable("Register") {
                    Register() {
                        // TodoView(viewModel = todoViewModel)
                        navController.navigate("Todo")
                    }
                }
                /*
                composable("Todo") {
                    Todo(){
                        TodoView(viewModel = todoViewModel)
                    }
                }
                */

            }
        }

    }
}

@Composable
fun Login(
    onLoginButtonClicked: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Login",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
        )
        Button(onClick = onLoginButtonClicked) {
            Text(
                text = "Login",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        /*
        Button(onClick = onRegButtonClicked) {
            Text(
                text = "Register new user",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        */

    }

}

@Composable
fun Register(
    onButtonClicked: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Register",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
        )
        Button(onClick = onButtonClicked) {
            Text(
                text = "Register new user",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Button(onClick = onButtonClicked) {
            Text(
                text = "Login",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun Todo(
    // onTodoButtonClicked: @Composable () -> Unit
) {
    var showTodo: Boolean = false
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Todo",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
        )
        Button(onClick = {
            TodoView(viewModel = todoViewModel)
        }) {
            Text(
                text = "Start Todo",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
