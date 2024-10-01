package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.Movie

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    fun viewCreated(): List<Movie> {
        return getMoviesUseCase.invoke()
    }

    fun itemSelected(movieId: String): Movie? {
        return getMovieUseCase.invoke(movieId)
    }

}