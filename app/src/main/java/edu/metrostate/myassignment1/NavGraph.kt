package edu.metrostate.myassignment1

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.metrostate.myassignment1.models.HomeViewModel
import edu.metrostate.myassignment1.models.RegisterViewModel
import edu.metrostate.myassignment1.models.TodoViewModel

@Composable
fun NavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeView(viewModel = HomeViewModel(), navController)
        }
        composable(
            route = Screen.Register.route
        ){
            RegisterView(viewModel = RegisterViewModel(), navController)
        }
        composable(
            route = Screen.Todo.route
        ){
            TodoView(viewModel = TodoViewModel(), navController)
        }
    }
}
