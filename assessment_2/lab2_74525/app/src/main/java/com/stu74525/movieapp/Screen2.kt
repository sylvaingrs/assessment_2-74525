package com.stu74525.movieapp

import androidx.compose.runtime.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(navController: NavController, actual:Movie) {
    var seatsSelected by remember { mutableStateOf(0) }
    /*
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "App Bar")
                },
                colors = topAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = fontColor
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.DarkGray,
                contentColor = fontColor
            ) {
                Text(text = "Bottom Nav Bar")
            }
        },
    ) { innerPadding ->

    }

     */
    Column(
        modifier = Modifier
            .background(dark)
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {

        Row(
            modifier = Modifier
                .padding(start = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = null,
                modifier = Modifier

                    .clickable { navController.navigate(Routes.FirstScreen.route) }
                    .size(30.dp, 30.dp)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = actualMovie.name,
                fontSize = 35.sp,
                color = fontColor,
            )
        }

        Image(
            painter = painterResource(id = actualMovie.imagePah),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp, top = 10.dp)
        )
        Column(

        ) {
            Text(
                text = "Starring: ",
                fontWeight = FontWeight.Bold,
                color = fontColor,
                fontSize = fontSize.sp,
            )
            Text(
                text = actualMovie.starring.joinToString() + "\n",
                color = fontColor,
                fontSize = fontSize.sp,
            )
            Row {
                Text(
                    text = "Running time: ",
                    color = fontColor,
                    fontSize = fontSize.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = actualMovie.runningTimeMins + "\n",
                    color = fontColor,
                    fontSize = fontSize.sp,
                )
            }
            Row {
                Text(
                    text = "Age limit: ",
                    color = fontColor,
                    fontSize = fontSize.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = actualMovie.certification + "\n",
                    color = fontColor,
                    fontSize = fontSize.sp,
                )
            }
            Text(
                text = actualMovie.description,
                color = fontColor,
                fontSize = fontSize.sp
            )
        }
        SeatSelectionScreen(actual)
    }
}



