package com.example.application;

class TmdbMovieResult(
    var page: Int = 0,
    val results: kotlin.collections.List<Any> = listOf())

class TmdbMovie(
    var overview: String = "",
    val release_date: String = "",
    val id: String = "",
    val title: String = "",
    val original_title: String = "",
    val backdrop_path: String? = "",
    val genre_ids: kotlin.collections.List<Any> = listOf(),
    val poster_path: String? = "")