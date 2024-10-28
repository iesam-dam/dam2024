package edu.iesam.dam2024.features.superhero.data.remote

import edu.iesam.dam2024.features.superhero.domain.SuperHero

data class SuperHeroApiModel(val id: String, val name: String, val images: SuperHeroImageApiModel)
data class SuperHeroImageApiModel(val lg: String)
