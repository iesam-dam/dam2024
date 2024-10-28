package edu.iesam.dam2024.features.superhero.data.remote

import edu.iesam.dam2024.features.superhero.domain.SuperHero

fun SuperHeroApiModel.toModel(): SuperHero{
    return SuperHero(this.id, this.name, this.images.lg )
}