package edu.iesam.dam2024.features.superhero.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import edu.iesam.dam2024.features.superhero.domain.Power

const val SUPERHERO_TABLE = "superhero"
const val SUPERHERO_ID = "superhero_id"

@Entity(tableName = SUPERHERO_TABLE)
class SuperHeroEntity(
    @PrimaryKey @ColumnInfo(name = SUPERHERO_ID) val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "url_image") val urlImage: String,
    @Embedded(prefix = "power") val power: Power
)