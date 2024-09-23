package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieViewModel(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    fun viewCreated(): List<Movie> {
        return getMoviesUseCase.invoke()
    }

    fun itemSelected(movieId: String){
        //TODO
    }

}