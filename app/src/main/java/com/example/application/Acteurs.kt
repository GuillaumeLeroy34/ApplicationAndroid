package com.example.application

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun ActorsScreen(navController: NavController) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BottomNavBar(navController)
        ListeActors(
            actorVM = MainViewModel(),
            navController = navController,
            nbColumns = 2,
            modifier = Modifier
        )
    }
}


@Composable

fun ListeActors(
    actorVM: MainViewModel,
    navController: NavController,
    nbColumns: Int,
    modifier: Modifier
) {
    val actors by actorVM.actors.collectAsState()

    if (actors.results.isEmpty()) {
        actorVM.getActorsInitiaux()
    }
    if (actors.results.isNotEmpty()) {
        LazyVerticalGrid(columns = GridCells.Fixed(nbColumns), modifier = modifier) {
            items(actors.results) { actor ->
                FloatingActionButton(
                    onClick = { navController.navigate("Detailactor/${actor.id}") },
                    modifier = Modifier.padding(20.dp),
                    containerColor = Color.White,
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()
                        ) {

                        }
                        Column(
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier.padding(start = 10.dp)
                        ) {
                            Text(
                                text = actor.name,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier.padding(top = 5.dp)
                            )
                            AsyncImage(
                                model = "https://image.tmdb.org/t/p/w780/${actor.profile_path}",
                                contentDescription = "Affiche de ${actor.name}"
                            )
                            Text(
                                text = actor.name,
                                textAlign = TextAlign.Center,
                                textDecoration = TextDecoration.Underline
                            )

                        }

                    }
                }
            }
        }
    }
}



