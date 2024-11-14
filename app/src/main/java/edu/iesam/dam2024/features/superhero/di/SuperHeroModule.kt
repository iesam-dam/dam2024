package edu.iesam.dam2024.features.superhero.di

import edu.iesam.dam2024.app.data.local.db.SuperHeroDataBase
import edu.iesam.dam2024.features.superhero.data.local.db.SuperHeroDao
import org.koin.core.annotation.Single

class SuperHeroModule {

    @Single
    fun provideSuperHeroDao(db: SuperHeroDataBase): SuperHeroDao {
        return db.superHeroDao()
    }
}