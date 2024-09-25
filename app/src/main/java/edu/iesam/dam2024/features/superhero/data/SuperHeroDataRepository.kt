package edu.iesam.dam2024.features.superhero.data

import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository

class SuperHeroDataRepository(private val remoteDataSource: SuperHeroMockRemoteDataSource) :
    SuperHeroRepository {

    override fun findAll(): List<SuperHero> {
        return remoteDataSource.getSuperHeroes()
    }
}