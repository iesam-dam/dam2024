package edu.iesam.dam2024.features.movies.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun save(movie: Movie) {
        sharedPref
            .edit().apply {
                putString("id", movie.id)
                putString("title", movie.title)
                putString("poster", movie.poster)
                apply()
            }
    }

    fun saveAll(movies: List<Movie>) {
        val editor = sharedPref.edit()
        movies.forEach { movie ->
            editor.putString(movie.id, gson.toJson(movie))
        }
        editor.apply()
    }

    fun find(): Movie {
        sharedPref.apply {
            return Movie(
                getString("id", "")!!,
                getString("title", "")!!,
                getString("poster", "")!!
            )
        }
    }

    fun findAll(): List<Movie>{
        val movies = ArrayList<Movie>()
        val mapMovies = sharedPref.all //as Map<String, String>
        mapMovies.values.forEach { jsonMovie ->
            val movie = gson.fromJson(jsonMovie as String, Movie::class.java)
            movies.add(movie)
        }
        return movies
    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }

}