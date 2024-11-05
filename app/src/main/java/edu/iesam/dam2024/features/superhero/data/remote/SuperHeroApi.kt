package edu.iesam.dam2024.features.superhero.data.remote

import com.google.gson.annotations.SerializedName
import edu.iesam.dam2024.features.superhero.domain.SuperHero

data class SuperHeroApiModel(val id: String,
                             val name: String,
                             val images: SuperHeroImageApiModel,
                             @SerializedName("url_image") val urlImage: String)

data class SuperHeroImageApiModel(val lg: String)
