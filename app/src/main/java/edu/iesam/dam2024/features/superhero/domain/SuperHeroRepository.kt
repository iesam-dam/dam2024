package edu.iesam.dam2024.features.superhero.domain

interface SuperHeroRepository {
    suspend fun findAll(): Result<List<SuperHero>>
    suspend fun findById(superHeroId: String): SuperHero
}