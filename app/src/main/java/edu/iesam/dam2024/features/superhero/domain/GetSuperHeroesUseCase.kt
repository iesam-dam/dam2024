package edu.iesam.dam2024.features.superhero.domain

class GetSuperHeroesUseCase(private val superHeroRepository: SuperHeroRepository) {

    suspend operator fun invoke(): Result<List<SuperHero>> {
        return superHeroRepository.findAll()
    }
}