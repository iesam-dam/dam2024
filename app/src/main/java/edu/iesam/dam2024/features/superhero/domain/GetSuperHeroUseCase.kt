package edu.iesam.dam2024.features.superhero.domain

class GetSuperHeroUseCase(private val superHeroRepository: SuperHeroRepository) {

    suspend operator fun invoke(superHeroId: String): SuperHero {
        return superHeroRepository.findById(superHeroId)
    }
}