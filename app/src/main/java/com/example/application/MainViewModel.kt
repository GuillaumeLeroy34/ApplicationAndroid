package com.example.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel: ViewModel() {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build();

    val api = retrofit.create(com.example.application.APITMDB::class.java)


    val movies = MutableStateFlow<MovieList>(MovieList())
    val series = MutableStateFlow<SerieList>(SerieList())
    val actors = MutableStateFlow<ActorList>(ActorList())

    val detailActor = MutableStateFlow<Actor>(Actor())
    val detailSerie = MutableStateFlow<Serie>(Serie())
    val detailMovie = MutableStateFlow<Movie>(Movie())
    fun getFilmInitiaux(){
        viewModelScope.launch {
            movies.value = api.lastmovies("ae21f15bbb373aabf4421d4fdef76076")
        }
    }

    fun getSeriesInitiales(){
        viewModelScope.launch{
            series.value = api.lastseries("ae21f15bbb373aabf4421d4fdef76076")
        }
    }

    fun getActorsInitiaux(){
        viewModelScope.launch{
            actors.value = api.lastactors("ae21f15bbb373aabf4421d4fdef76076")
        }
    }

    fun getDetailActor(id: String){
        viewModelScope.launch{
            detailActor.value = api.actorindividuel(id,"ae21f15bbb373aabf4421d4fdef76076")
        }
    }


    fun getDetailFilm(id: String){
        viewModelScope.launch{
            detailMovie.value = api.filmindividuel(id,"ae21f15bbb373aabf4421d4fdef76076")
        }
    }

    fun getDetailSerie(id: String){
        viewModelScope.launch{
            detailSerie.value = api.serieindividuelle(id,"ae21f15bbb373aabf4421d4fdef76076")
        }
    }


}
