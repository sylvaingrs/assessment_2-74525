package com.stu74525.movieapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.FirstScreen.route,
        //startDestination = Routes.SecondScreen.route
    ) {
        composable(route = Routes.FirstScreen.route) {
            Screen1(navController = navController)
        }

        composable(route = Routes.SecondScreen.route + "/movie1") {
            Screen2(navController = navController, actual = movie1)
        }

        //composable(route = Routes.SecondScreen.route)  {
        //    Screen2(navController = navController, actual = movie1)
        //}

        composable(route = Routes.SecondScreen.route + "/movie2") {
            Screen2(navController = navController, actual = movie2)
        }

        composable(route = Routes.SecondScreen.route + "/movie3") {
            Screen2(navController = navController, actual = movie3)
        }

        composable(route = Routes.SecondScreen.route + "/movie4") {
            Screen2(navController = navController, actual = movie4)
        }
    }
}
