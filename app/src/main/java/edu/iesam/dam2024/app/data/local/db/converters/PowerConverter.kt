package edu.iesam.dam2024.app.data.local.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import edu.iesam.dam2024.features.superhero.domain.Power

class PowerConverter {

    @TypeConverter
    fun from(power: String): Power {
        return Gson().fromJson(power, Power::class.java)
    }

    @TypeConverter
    fun to(power: Power): String {
        return Gson().toJson(power, Power::class.java)
    }
}