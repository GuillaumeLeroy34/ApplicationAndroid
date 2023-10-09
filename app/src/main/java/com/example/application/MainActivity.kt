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

                    MonImage()
                    //todo: réparer le bouton pété MonBouton()


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
} //exemple: todo: à retirer

@Composable
fun MonImage() {

    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceAround,
    horizontalAlignment = Alignment.CenterHorizontally


    ) {


    Image(
        painterResource(id = R.drawable.chat),
        contentDescription = "le chat",
        modifier = Modifier
            .requiredSize(250.dp)
            .padding(10.dp)
            .clip(CircleShape),

        contentScale = ContentScale.Crop
    )
        Legende()
    }
}
@Composable
fun MonBouton(){
    Button(onClick = { print("ligma") }) {

    }
}
@Composable
fun Legende() {
    Text(text = "un chat pour les gouverner tous")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApplicationTheme {
        Greeting("Android")
    }


@Composable
    fun MyAppNavHost(
        modifier: Modifier = Modifier,
        navController: NavHostController = rememberNavController(),
        startDestination: String = "profile"
    ) {
        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = startDestination
        ){
            composable("profil") {
                Profil(
                )
            }
            composable("films") { Films(/*...*/) }
        }
    }




}