package edu.iesam.dam2024.app.data.api

import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    //La url que no cambia en cada uno de los servicios.
    // Termina en /
    private const val BASE_URL_API = "https://akabab.github.io/superhero-api/api/"

    /**
     * Creo Retrofit.
     * Importante: Añado el converter seleccionado.
     */
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}