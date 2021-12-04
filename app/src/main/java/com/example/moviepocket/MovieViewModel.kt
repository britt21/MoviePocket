package com.example.moviepocket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviepocket.movies.Moviedata
import com.example.moviepocket.movies.Result
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

  private val _movies =  MutableLiveData<List<Result>>()

          val movies: LiveData<List<Result>>

          get() = _movies



    init {
        getMovies()

    }


  private fun getMovies() {
      viewModelScope.launch {
          try {
              val response = MovieApi.RetrofitService.getMovies()
              _movies.postValue(response.results)
          }catch (e: Exception){

          }

      }

}

}