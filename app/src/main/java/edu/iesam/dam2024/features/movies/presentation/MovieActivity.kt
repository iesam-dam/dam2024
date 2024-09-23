package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieActivity : AppCompatActivity() {

    private val moviewFactory: MovieFactory = MovieFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = moviewFactory.buildViewModel()
        val movies = viewModel.viewCreated()
        Log.d("@dev", movies.toString()) // Los visualizo
        viewModel.itemSelected(movies.first().id) //Simular un click sobre un item
    }

}