package edu.iesam.dam2024.features.superhero.presentation

import edu.iesam.dam2024.app.data.local.db.SuperHeroDataBase
import edu.iesam.dam2024.app.data.remote.api.ApiClient
import edu.iesam.dam2024.features.superhero.data.SuperHeroDataRepository
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroApiRemoteDataSource
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroService
import edu.iesam.dam2024.features.superhero.di.SuperHeroModule
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroesUseCase

class SuperHeroFactory {

    private val superHeroMockRemoteDataSource = SuperHeroMockRemoteDataSource()

    private val superHeroDataRepository =
        SuperHeroDataRepository(getSuperHeroApiRemoteDataSource())

    private val getSuperHeroesUseCase = GetSuperHeroesUseCase(superHeroDataRepository)
    private val getSuperHeroUseCase = GetSuperHeroUseCase(superHeroDataRepository)

    fun getSuperHeroListViewModel(): SuperHeroListViewModel {
        return SuperHeroListViewModel(getSuperHeroesUseCase)
    }

    private fun getSuperHeroApiRemoteDataSource(): SuperHeroApiRemoteDataSource {
        return SuperHeroApiRemoteDataSource()
    }

    fun getSuperHeroDetailViewModel(): SuperHeroDetailViewModel {
        return SuperHeroDetailViewModel(getSuperHeroUseCase)
    }


}