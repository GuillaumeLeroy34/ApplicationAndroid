package com.example.application

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APITMDB {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): MovieList


    @GET("trending/tv/week")
    suspend fun lastseries(@Query("api_key") api_key: String): SerieList


    @GET("trending/person/week")
    suspend fun lastactors(@Query("api_key") api_key: String): ActorList
}

