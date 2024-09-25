package edu.iesam.dam2024.features.superhero.domain

class GetSuperHeroesUseCase(private val superHeroRepository: SuperHeroRepository) {

    operator fun invoke(): List<SuperHero> {
        return superHeroRepository.findAll()
    }
}