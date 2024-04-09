package com.stu74525.movieapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import kotlin.random.Random
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

val dark: Color = Color(17,17,17)
val lightDark: Color = Color(45,45,45)
val fontColor: Color = Color(203,213,224)
val fontSize: Int = 20;

val random1 = Random
val random2 = Random
val random3 = Random
val random4 = Random



data class Movie(
    var name: String,
    var imagePah: Int,
    var certification: String,
    var description: String,
    var starring: List<String>,
    var runningTimeMins: String,
    var seatsRemaining: Int,
    var seatsSelected: Int
)

val actualMovie: Movie = Movie(
    name = "",
    imagePah = 0,
    certification = "",
    description = "",
    starring = listOf(),
    runningTimeMins = "",
    seatsSelected = 0,
    seatsRemaining = 0,
)

val movie1: Movie = Movie(
    name = "Avengers 4",
    imagePah = R.drawable.avenger,
    certification = "12+",
    description = "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.",
    starring = listOf("Robert Downey Jr.", "Scarlett Johansson", "Chris Evans", "Chris Hemsworth", "Mark Ruffalo"),
    runningTimeMins = "3h02",
    seatsSelected = 0,
    seatsRemaining = random1.nextInt(1,16),
)

val movie2: Movie = Movie(
    name = "Cars",
    imagePah = R.drawable.cars,
    certification = "3+",
    description = "On the way to the biggest race of his life, a hotshot rookie race car gets stranded in a rundown town and learns that winning isn't everything in life.",
    starring = listOf("Owen Wilson", "Bonnie Hunt", "Paul Newman", "Larry The Cable Guy", "John Ratzenberger"),
    runningTimeMins = "1h57",
    seatsSelected = 0,
    seatsRemaining = random2.nextInt(1,16)
)

val movie3: Movie = Movie(
    name = "Inception",
    imagePah = R.drawable.inception5,
    certification = "13+",
    description = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.",
    starring = listOf("Leonardo DiCaprio", "Cillian Murphy", "Joseph Gordon-Lewitt", "Tom Hardy", "Elliot Page"),
    runningTimeMins = "2h28",
    seatsSelected = 0,
    seatsRemaining = random3.nextInt(1,16)
)

val movie4: Movie = Movie(
    name = "Star Wars III",
    imagePah = R.drawable.starwars,
    certification = "14+",
    description = "Three years into the Clone Wars, Obi-Wan pursues a new threat, while Anakin is lured by Chancellor Palpatine into a sinister plot to rule the galaxy.",
    starring = listOf("Hayden Christensen", "Ewan McGregor", "Ian McDiarmid", "Natalie Portman", "Jimmy Smits"),
    runningTimeMins = "2h26",
    seatsSelected = 0,
    seatsRemaining = random4.nextInt(1,16)
)

val remainingFirst = actualMovie.seatsRemaining

fun movieSelected(movie: Movie) {
    actualMovie.name = movie.name
    actualMovie.imagePah = movie.imagePah
    actualMovie.certification = movie.certification
    actualMovie.description = movie.description
    actualMovie.runningTimeMins = movie.runningTimeMins
    actualMovie.seatsRemaining = movie.seatsRemaining
    actualMovie.seatsSelected = movie.seatsSelected
    actualMovie.starring = movie.starring
}

class SharedViewModel : ViewModel() {

    private val _seatsInfo = MutableLiveData(actualMovie.seatsRemaining.toString() + " seats remaining")
    val seatsInfo: LiveData<String> = _seatsInfo

    //var seatsInfo by mutableStateOf(actualMovie.seatsRemaining.toString() + " seats remaining")
    fun updateText(newText: String) {
        _seatsInfo.value = newText
    }
}



@Composable
fun UpdateSeats(viewModel: SharedViewModel = viewModel()) {
    val seatsInfo = viewModel.seatsInfo
    Text(
        color = fontColor,
        text = "text : " + seatsInfo,
        fontSize = fontSize.sp
    )
}


@Composable
fun SeatsSelectedRemaining(actual:Movie) {
    if (actual.seatsSelected == 0) {
        Text(
            color = fontColor,
            text = actual.seatsRemaining.toString() + " seats rem.",
            fontSize = fontSize.sp
        )
    }
    else {
        Text(
            color = Color.Red,
            text = actual.seatsSelected.toString() + " seats sel.",
            fontSize = fontSize.sp
        )
    }

}


@Composable
fun SeatSelectionScreen(actual: Movie) {
    var seatsSelected by remember { mutableStateOf(actualMovie.seatsSelected) }
    var seatsRemaining by remember { mutableStateOf(actualMovie.seatsRemaining) }

    //val seatsInfo = viewModel.seatsInfo


    fun changeSelectedSeats(change: Char) {
        if (change == '+') {
            if (seatsRemaining > 0) {
                seatsSelected++
                actual.seatsSelected++

                seatsRemaining--
                actual.seatsRemaining--
            }
        } else if (change == '-') {
            if (seatsSelected > 0) {
                seatsSelected--
                actual.seatsSelected--
                seatsRemaining++
                actual.seatsRemaining++
            }
        } else {
            seatsSelected += seatsRemaining
            actual.seatsSelected += actual.seatsRemaining
            seatsRemaining = 0
            actual.seatsRemaining = 0
        }

    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 0.dp, start = 15.dp, end = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Select seats",
            color = fontColor,
            fontSize = fontSize.sp
        )
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            modifier = Modifier
                .size(65.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.minus),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp, 20.dp)
                    .clickable {
                        changeSelectedSeats('-')
                    }
            )
            Text(
                text = seatsSelected.toString(),
                color = fontColor,
                fontSize = 16.sp
            )
            Image(
                painter = painterResource(id = R.drawable.add),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp, 20.dp)
                    .clickable {
                        changeSelectedSeats('+')
                    }
            )

        }
        Spacer(modifier = Modifier.size(25.dp))
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Select All",
                color = fontColor,
                fontSize = fontSize.sp
            )
            Spacer(modifier = Modifier.size(5.dp))
            Image(
                painter = painterResource(id = R.drawable.selectall),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp, 30.dp)
                    .clickable { changeSelectedSeats(' ') }
            )
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = seatsRemaining.toString() + " seats remaining",
            color = fontColor,
            fontSize = fontSize.sp
        )
        Spacer(modifier = Modifier.size(width = 15.dp, height = 1.dp))
        Image(
            painter = painterResource(id = R.drawable.armchair),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp, 30.dp)
        )
    }

}
