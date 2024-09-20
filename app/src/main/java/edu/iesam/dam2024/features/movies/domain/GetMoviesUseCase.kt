package edu.iesam.dam2024.features.movies.domain

/**
 * Naming: Verbo(Acción) + UseCase
 */
class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke(): List<Movie> {
        return movieRepository.getMovies()
    }
}