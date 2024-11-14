package edu.iesam.dam2024.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.dam2024.app.data.local.db.converters.PowerConverter
import edu.iesam.dam2024.features.superhero.data.local.db.SuperHeroDao
import edu.iesam.dam2024.features.superhero.data.local.db.SuperHeroEntity

@Database(entities = [SuperHeroEntity::class], version = 1, exportSchema = false)
@TypeConverters(PowerConverter::class)
abstract class SuperHeroDataBase : RoomDatabase() {

    //Se declaran los DAO
    abstract fun superHeroDao(): SuperHeroDao
}