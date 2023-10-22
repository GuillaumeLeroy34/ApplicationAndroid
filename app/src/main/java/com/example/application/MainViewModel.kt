package com.example.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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


    fun getFilmInitiaux(){
        viewModelScope.launch {
            movies.value = api.lastmovies("ae21f15bbb373aabf4421d4fdef76076")
        }
    }

}
