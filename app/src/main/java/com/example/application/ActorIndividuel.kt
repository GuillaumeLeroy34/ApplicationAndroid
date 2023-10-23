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
fun ActeurIndividuelScreen(navController: NavController, id: String) {
    Column(
        Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ActeurIndiv(id = id, navController = navController, modifier = Modifier)
        BottomNavBar(navController)
    }
}

fun getGenre(valeur: Int): String {
    var retour: String = ""
    when(valeur){
        0 -> retour = "Homme"
        1 -> retour = "Femme"
    }
    return retour
}


@Composable
fun ActeurIndiv(id: String,navController: NavController, modifier: Modifier) {
    val acteurIndVM: MainViewModel = viewModel()

    LaunchedEffect(key1 = true){
        acteurIndVM.getDetailActor(id)
    }

    val acteur by acteurIndVM.detailMovie.collectAsState()




    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Text(text = acteur.name)

//        AsyncImage(
//            model = "https://image.tmdb.org/t/p/w780/${acteur.profile_path}",
//            contentDescription = "Affiche de ${acteur.name}")
//        Text(text = "getGenre(acteur.gender)")
    }


}