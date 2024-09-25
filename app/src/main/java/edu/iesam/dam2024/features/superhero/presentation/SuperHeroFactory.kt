package edu.iesam.dam2024.features.superhero.presentation

import edu.iesam.dam2024.features.superhero.data.SuperHeroDataRepository
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroesUseCase

class SuperHeroFactory {

    private val superHeroMockRemoteDataSource = SuperHeroMockRemoteDataSource()
    private val superHeroDataRepository = SuperHeroDataRepository(superHeroMockRemoteDataSource)
    private val getSuperHeroesUseCase = GetSuperHeroesUseCase(superHeroDataRepository)

    fun buildViewModel(): SuperHeroViewModel {
        return SuperHeroViewModel(getSuperHeroesUseCase)
    }

}