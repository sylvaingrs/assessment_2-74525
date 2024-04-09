package com.stu74525.movieapp

sealed class Routes(val route: String) {
    object FirstScreen: Routes("first_screen")
    object SecondScreen: Routes("second_screen")
}