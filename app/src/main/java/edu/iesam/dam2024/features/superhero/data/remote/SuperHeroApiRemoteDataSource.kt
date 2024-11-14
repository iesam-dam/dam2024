package edu.iesam.dam2024.features.superhero.data.remote

import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroApiRemoteDataSource(private val superHeroService: SuperHeroService) {

    suspend fun getSuperHeroes(): Result<List<SuperHero>>{
        val response = superHeroService.requestSuperHeroes()
        if (response.isSuccessful){
            val superHeroes = response.body()!!.map {
                it.toModel()
            }
            return Result.success(superHeroes)
        } else {
            //Hay un error
            return Result.failure(ErrorApp.ServerErrorApp)
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