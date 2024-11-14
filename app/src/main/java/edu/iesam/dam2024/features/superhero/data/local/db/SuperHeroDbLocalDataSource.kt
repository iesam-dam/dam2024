package edu.iesam.dam2024.features.superhero.data.local.db

import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroDbLocalDataSource(private val superHeroDao: SuperHeroDao) {

    suspend fun findAll(): List<SuperHero> {
        return superHeroDao.findAll().map {
            it.toDomain()
        }
    }

    suspend fun findById(superheroId: String): SuperHero {
        return superHeroDao.findById(superheroId).toDomain()
    }

    suspend fun saveAll(superheroes: List<SuperHero>) {
        val superHeroesList = superheroes.map {
            it.toEntity()
        }
        superHeroDao.saveAll(*superHeroesList.toTypedArray())
    }

    suspend fun save(superHero: SuperHero) {
        superHeroDao.save(superHero.toEntity())
    }

    suspend fun delete(superheroId: String) {
        superHeroDao.deleteById(superheroId)
    }
}