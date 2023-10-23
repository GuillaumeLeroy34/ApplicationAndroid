package com.example.application

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
fun SerieIndividuelleScreen(navController: NavController, id: String) {
    Column(
        Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SerieIndiv(id = id, navController = navController, modifier = Modifier)
        BottomNavBar(navController)
    }
}

@Composable
fun SerieIndiv(id: String,navController: NavController, modifier: Modifier) {
    val serieIndVM: MainViewModel = viewModel()

    LaunchedEffect(key1 = true){
        serieIndVM.getDetailSerie(id)
    }

    val serie by serieIndVM.detailSerie.collectAsState()

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = serie.name)

        AsyncImage(
            model = "https://image.tmdb.org/t/p/w780/${serie.poster_path}",
            contentDescription = "Affiche de ${serie.name}")
        Text(text = serie.overview)
    }


}