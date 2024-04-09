package com.stu74525.movieapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen1(navController: NavController) {
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
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .background(dark)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Movie App",
            fontSize = 40.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(dark)
                .padding(5.dp)
        ) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(5))
                    .background(lightDark)
                    .fillMaxSize()
                    .padding(25.dp, 20.dp, 25.dp, 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                    //.background(Color.Red)
                    ,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = movie1.name,
                            color = fontColor,
                            fontSize = fontSize.sp,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier
                                .padding(bottom = 15.dp)
                            )
                        Image(
                            painter = painterResource(id = R.drawable.avenger2),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(RoundedCornerShape(10))
                                .size(155.dp, 230.dp)
                                .clickable {
                                    movieSelected(movie = movie1)

                                    //navController.navigate(Routes.SecondScreen.route)
                                    navController.navigate("${Routes.SecondScreen.route}/movie1")
                                }
                        )
                        //UpdateSeats()
                        SeatsSelectedRemaining(actual = movie1)
                        /*
                        Text(
                            color = fontColor,
                            //text = "Seats selected: " + movie1.seatsSelected,
                            text = movie1.seatsRemaining.toString() + " seats rem.",
                            fontSize = fontSize.sp
                        )

                         */


                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = movie2.name,
                            color = fontColor,
                            fontSize = fontSize.sp,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier
                                .padding(bottom = 15.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.cars2),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(RoundedCornerShape(10))
                                .size(155.dp, 230.dp)
                                .clickable {
                                    movieSelected(movie = movie2)
                                    navController.navigate("${Routes.SecondScreen.route}/movie2")
                                    //navController.navigate(Routes.SecondScreen.route)
                                }
                        )
                        SeatsSelectedRemaining(actual = movie2)
                        /*
                        Text(
                            color = fontColor,
                            //text = "Seats selected: " + movie2.seatsSelected,
                            text = movie2.seatsRemaining.toString() + " seats rem.",
                            fontSize = fontSize.sp
                        )

                         */
                    }
                }
                //Spacer(modifier = Modifier.padding(5.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                    //.background(Color.Blue)
                    ,

                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = movie3.name,
                            color = fontColor,
                            fontSize = fontSize.sp,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier
                                .padding(bottom = 15.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.inception2),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(RoundedCornerShape(10))
                                .size(155.dp, 230.dp)
                                .clickable {
                                    movieSelected(movie = movie3)
                                    navController.navigate("${Routes.SecondScreen.route}/movie3")
                                    //navController.navigate(Routes.SecondScreen.route)
                                }
                        )
                        SeatsSelectedRemaining(actual = movie3)
                        /*
                        Text(
                            color = fontColor,
                            //text = "Seats selected: " + movie3.seatsSelected,
                            text = movie3.seatsRemaining.toString() + " seats rem.",
                            fontSize = fontSize.sp
                        )

                         */
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = movie4.name,
                            color = fontColor,
                            fontSize = fontSize.sp,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier
                                .padding(bottom = 15.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.starwars2),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(RoundedCornerShape(10))
                                .size(155.dp, 230.dp)
                                .clickable {
                                    movieSelected(movie = movie4)
                                    navController.navigate("${Routes.SecondScreen.route}/movie4")
                                    //navController.navigate(Routes.SecondScreen.route)
                                }
                        )
                        SeatsSelectedRemaining(actual = movie4)
                        /*
                        Text(
                            color = fontColor,
                            //text = "Seats selected: " + movie4.seatsSelected,
                            text = movie4.seatsRemaining.toString() + " seats rem.",
                            fontSize = fontSize.sp
                        )

                         */
                    }

                }
            }
        }
    }
}
