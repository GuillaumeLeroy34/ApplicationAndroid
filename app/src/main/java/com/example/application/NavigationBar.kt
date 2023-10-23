package com.example.application


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController


@Composable
@UiComposable
fun TabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = contentColorFor(backgroundColor),
    indicator: @Composable @UiComposable (tabPositions: List<TabPosition>) -> Unit = @Composable { tabPositions ->
        TabRowDefaults.Indicator(
            Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
        )
    },
    tabs: @Composable @UiComposable () -> Unit
): Unit {

}


@Composable
fun BottomNavBar(
    navController: NavController,
    filmsSelected: Boolean = false,
    seriesSelected: Boolean = false,
    personsSelected: Boolean = false
) {

    val tintFilm = if (filmsSelected) {
        Color.White
    } else {
        Color(0xFFb3b1b1)
    }

    val tintSerie = if (seriesSelected) {
        Color.White
    } else {
        Color(0xFFb3b1b1)
    }

    val tintPerson = if (personsSelected) {
        Color.White
    } else {
        Color(0xFFb3b1b1)
    }


    BottomAppBar(
        containerColor = Color(0xFF2596BE),
        actions = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { navController.navigate("series") }) {
                    Text(text = "Series")
                }
                Button(onClick = { navController.navigate("films") }) {
                    Text(text = "Films")
                }
                Button(onClick = { navController.navigate("acteurs") }) {
                    Text(text = "Acteurs")
                }

            }
        }
    )


}