package com.stu74525.movieapp

import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun ToScreen2Button(onClick: () -> Unit) {
    ElevatedButton(
        onClick = { onClick() }
    ) {
        Text("Go to Screen 2")
    }
}

@Composable
fun DescriptionMovieButton(onClick: () -> Unit) {

}