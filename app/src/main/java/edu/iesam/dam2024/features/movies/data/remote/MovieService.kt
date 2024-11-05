package edu.iesam.dam2024.features.movies.data.remote

import edu.iesam.dam2024.features.movies.domain.Movie
import retrofit2.http.GET

interface MovieService {

    @GET
    fun getMovies(): List<Movie>
}