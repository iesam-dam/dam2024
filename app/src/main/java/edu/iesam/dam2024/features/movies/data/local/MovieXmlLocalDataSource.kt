package edu.iesam.dam2024.features.movies.data.local

import android.content.Context
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE
    )

    fun save(movie: Movie) {
        val editor = sharedPref.edit()
        editor.putString("id", movie.id)
        editor.putString("title", movie.title)
        editor.putString("poster", movie.poster)
        editor.apply()
    }

    fun findMovie(): Movie{
        val id = sharedPref.getString("id", "")
        val title = sharedPref.getString("title", "")
        val poster = sharedPref.getString("poster", "")
        return Movie(id!!, title!!, poster!!)
    }

}