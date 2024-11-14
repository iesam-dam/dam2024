package edu.iesam.dam2024.features.superhero.data

import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroApiRemoteDataSource
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository

class SuperHeroDataRepository(private val remoteDataSource: SuperHeroApiRemoteDataSource) :
    SuperHeroRepository {

    override suspend fun findAll(): Result<List<SuperHero>> {
        return remoteDataSource.getSuperHeroes()
    }

    override suspend fun findById(superHeroId: String): SuperHero {
        return remoteDataSource.getSuperHero(superHeroId)
    }
}