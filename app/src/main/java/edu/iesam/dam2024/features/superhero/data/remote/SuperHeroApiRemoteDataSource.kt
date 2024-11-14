package edu.iesam.dam2024.features.superhero.data.remote

import edu.iesam.dam2024.features.superhero.domain.Power
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroApiRemoteDataSource() {

    suspend fun getSuperHeroes(): List<SuperHero>{
        return emptyList()
    }

    suspend fun getSuperHero(superHeroId: String): SuperHero{
        return SuperHero("1", "", "", Power("",""))
    }
}