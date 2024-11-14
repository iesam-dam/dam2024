package edu.iesam.dam2024.features.superhero.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface SuperHeroDao {

    @Query("SELECT * FROM $SUPERHERO_TABLE")
    suspend fun findAll(): List<SuperHeroEntity>


    @Query("SELECT * FROM $SUPERHERO_TABLE where $SUPERHERO_ID = :superheroId LIMIT 1")
    suspend fun findById(superheroId: String): SuperHeroEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(vararg superheroes: SuperHeroEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(superHero: SuperHeroEntity)

    @Update
    suspend fun updateUsers(vararg superheroes: SuperHeroEntity)

    @Update
    suspend fun updateUser(superHero: SuperHeroEntity)

    @Query("DELETE FROM $SUPERHERO_TABLE where $SUPERHERO_ID = :superheroId")
    suspend fun deleteById(superheroId: String)

    @Delete
    suspend fun delete(superHero: SuperHeroEntity)

}