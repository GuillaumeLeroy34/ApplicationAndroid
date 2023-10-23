package com.example.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun FilmIndivScreen(navController: NavController, id: String) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FilmIndiv(id = id, navController = navController, modifier = Modifier)
        BottomNavBar(navController)
    }
}

@Composable
fun FilmIndiv(id: String,navController: NavController, modifier: Modifier) {
    val filmIndVM: MainViewModel = viewModel()

    LaunchedEffect(key1 = true){
        filmIndVM.getDetailFilm(id)
    }

    val movie by filmIndVM.detailMovie.collectAsState()

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = movie.title)

        AsyncImage(
            model = "https://image.tmdb.org/t/p/w780/${movie.poster_path}",
            contentDescription = "Affiche de ${movie.title}")
        Text(text = movie.overview)
    }


}