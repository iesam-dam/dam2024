package edu.iesam.dam2024.features.superhero.data.remote

import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroApiRemoteDataSource(private val superHeroService: SuperHeroService) {

    suspend fun getSuperHeroes(): List<SuperHero>{
        val response = superHeroService.requestSuperHeroes()
        if (response.isSuccessful){
            return response.body()!!.map {
                it.toModel()
            }
        } else {
            //Hay un error
            return emptyList()
        }
    }

    suspend fun getSuperHero(superHeroId: String): SuperHero{
        val response = superHeroService.requestSuperHero(superHeroId)
        if (response.isSuccessful){
            return response.body()!!.toModel()
        } else {
            //Hay un error
            return SuperHero("error","error", "error")
        }
    }
}