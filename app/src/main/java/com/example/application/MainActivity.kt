package com.example.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.application.ui.theme.ApplicationTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    MainScreen()


                }
            }
        }
    }
}


@Composable
fun PhotoProfil() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


    }
}




@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "profil"
    ) {
        composable("profil"){
            ProfilScreen(navController)
        }
        composable("acteurs") {
            ActorsScreen(navController)
        }
        composable("films") {
           FilmsScreen(navController)
        }
        composable("series"){
            SeriesScreen(navController)
        }
        composable("filmIndividuel/{movieid}"){ backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieid") ?: ""
            FilmIndivScreen(navController,movieId)
        }
        composable("serieIndividuelle/{serieId}"){ backStackEntry ->
            val serieId = backStackEntry.arguments?.getString("serieId") ?: ""
            SerieIndividuelleScreen(navController,serieId)
        }
        composable("acteurIndividuel/{movieid}"){ backStackEntry ->
            val actorId = backStackEntry.arguments?.getString("actorId") ?: ""
            ActeurIndividuelScreen(navController,actorId)
        }
    }

}




