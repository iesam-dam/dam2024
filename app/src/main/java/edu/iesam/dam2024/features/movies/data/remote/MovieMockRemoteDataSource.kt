package edu.iesam.dam2024.features.movies.data.remote

import edu.iesam.dam2024.features.movies.domain.Movie

/**
 * Naming: Modelo + Tecnología + RemoteDataSource
 */
class MovieMockRemoteDataSource {

    private val movies = listOf(
        Movie("1", "title1", "https://pics.filmaffinity.com/the_sting-433653100-mmed.jpg"),
        Movie("2", "title2", "https://pics.filmaffinity.com/the_sting-433653100-mmed.jpg"),
        Movie("3", "title3", "https://pics.filmaffinity.com/the_sting-433653100-mmed.jpg."),
        Movie(title = "title4", poster = "https://pics.filmaffinity.com/the_sting-433653100-mmed.jpg", id = "4")
    )

    fun getMovies(): List<Movie> {
        return movies
    }

    fun getMovie(movieId: String): Movie? {
        return movies.firstOrNull { movie -> //renombro el it por movie
            //it es un objeto Movie del listado
            movie.id == movieId
        }
    }
}