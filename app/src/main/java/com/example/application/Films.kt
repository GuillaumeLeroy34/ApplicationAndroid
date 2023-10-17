package com.example.application

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun TexteTest() {
    Text(
        text = "routage réussi"
    )
}

@Composable
fun BoutonRetour(navController: NavController) {
    Button(onClick = { navController.navigate("profil") }) {
        Text(text = "Retour")
    }
}

@Composable
fun FilmsScreen(navController: NavController) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TexteTest()
        BoutonRetour(navController)
        ListeFilms(MainViewModel(),navController,2, Modifier)
    }
}

@Composable
fun ListeFilms(filmVM: MainViewModel, navController: NavController, nbColumns: Int, modifier: Modifier) {
    val movies by filmVM.movies.collectAsState()

    if (movies.results.isEmpty()) {
        filmVM.getFilmInitiaux()
    }
    if (movies.results.isNotEmpty()) {
        LazyVerticalGrid(columns = GridCells.Fixed(nbColumns), modifier = modifier) {
            items(movies.results) { movie ->
                FloatingActionButton(
                    onClick = {navController.navigate("DetailMovie/${movie.id}")},
                    modifier = Modifier.padding(20.dp),
                    containerColor = Color.White,
                ) {
                    Column( verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
                        Column( verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()) {

                        }
                        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(start = 10.dp)){
                            Text(text = movie.title,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier.padding(top = 5.dp))
                            }
                    }
                }
            }
        }
    }
}




