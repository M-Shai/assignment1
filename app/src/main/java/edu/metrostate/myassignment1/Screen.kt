package edu.metrostate.myassignment1

sealed class Screen (val route: String){
    data object Home: Screen("homeView")
    data object Register: Screen("registerView")
    data object Todo: Screen("todoView")
}