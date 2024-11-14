package edu.iesam.dam2024.features.superhero.domain

data class SuperHero(val id: String, val name: String, val urlImage: String, val power: Power)
data class Power(val name: String, val value: String)