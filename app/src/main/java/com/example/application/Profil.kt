package com.example.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun ProfilScreen(navController: NavController) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageProfil()
        Legende()
        BoutonStart(navController)
    }
}

@Composable
fun ImageProfil() {



        Image(
            painterResource(id = R.drawable.chat),
            contentDescription = "le chat",
            modifier = Modifier
                .requiredSize(250.dp)
                .padding(10.dp)
                .clip(CircleShape),

            contentScale = ContentScale.Crop
        )
    }


@Composable
fun BoutonStart(navController: NavController) {
    Button(onClick = { navController.navigate("Films") }) {
        Text(text = "Démarrer")
    }
}

@Composable
fun Legende() {
    Text(text = "un chat pour les gouverner tous")
}






