package edu.iesam.dam2024.features.superhero.data.remote

import edu.iesam.dam2024.features.superhero.domain.SuperHero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroService {

    //REST API: POST, GET, DELETE, PUT
    @GET("all.json")
    suspend fun requestSuperHeroes(): Response<List<SuperHeroApiModel>>

    @GET("id/{superHeroId}.json")
    suspend fun requestSuperHero(@Path("superHeroId") superHeroId: String): Response<SuperHeroApiModel>
}