package edu.metrostate.myassignment1

sealed class Screen (val route: String){
    object Home: Screen("homeView")
    object Register: Screen("registerView")
    object Todo: Screen("todoView")
}