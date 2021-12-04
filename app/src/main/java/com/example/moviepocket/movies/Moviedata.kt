package com.example.moviepocket.movies

data class Moviedata(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)