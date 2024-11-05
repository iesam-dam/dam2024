package edu.iesam.dam2024.features.movies.di

import edu.iesam.dam2024.features.movies.data.remote.MovieService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Module
@ComponentScan
class MovieModule {

    @Single
    fun provideMovieService(retrofit: Retrofit) =
        retrofit.create(MovieService::class.java)
}