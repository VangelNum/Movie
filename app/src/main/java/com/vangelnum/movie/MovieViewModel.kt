package com.vangelnum.movie

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel:ViewModel() {
    var movieListResponce:List<Movie> by mutableStateOf(listOf())

    fun getMovieList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            val movieList = apiService.getMovies()
            movieListResponce = movieList
        }
    }
}