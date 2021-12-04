package com.example.moviepocket

import com.example.moviepocket.movies.Moviedata
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

const val BASE_URL ="https://api.themoviedb.org"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MovieInterface{
    @GET("/3/movie/popular?api_key=0a9a56d12504c6d92ce90bc56144ef00&language=en-US&page=1")
  suspend fun getMovies():  Moviedata
}


object MovieApi {

     val RetrofitService : MovieInterface by lazy {
        retrofit.create(MovieInterface::class.java)
    }
}