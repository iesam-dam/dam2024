package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.Movie

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    fun viewCreated(): List<Movie> {
        return getMoviesUseCase.invoke()
    }
}