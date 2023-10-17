package com.example.application

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun FilmsScreen(navController: NavController){
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
    TexteTest()
    BoutonRetour(navController)
}
}


@Composable
fun TexteTest(){
    Text(text = "routage réussi")
}

@Composable
fun BoutonRetour(navController: NavController){
    Button(onClick = { navController.navigate("profil") }) {
        Text(text = "Retour")
    }
}