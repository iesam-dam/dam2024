package edu.iesam.dam2024.features.movies.data

import edu.iesam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.movies.domain.MovieRepository

/**
 * Naming: Modelo + DataRepository
 */
class MovieDataRepository(private val mockRemoteDataSource: MovieMockRemoteDataSource) :
    MovieRepository {

    override fun getMovies(): List<Movie> {
        return mockRemoteDataSource.getMovies()
    }

}