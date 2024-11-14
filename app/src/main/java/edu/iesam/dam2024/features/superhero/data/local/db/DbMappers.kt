package edu.iesam.dam2024.features.superhero.data.local.db

import edu.iesam.dam2024.features.superhero.domain.SuperHero

fun SuperHero.toEntity(): SuperHeroEntity =
    SuperHeroEntity(this.id, this.name, this.urlImage, this.power)

fun SuperHeroEntity.toDomain(): SuperHero =
    SuperHero(this.id, this.name, this.urlImage, this.power)