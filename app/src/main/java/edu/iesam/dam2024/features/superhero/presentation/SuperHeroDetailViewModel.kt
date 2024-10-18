package edu.iesam.dam2024.features.superhero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.presentation.SuperHeroListViewModel.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperHeroDetailViewModel(private val getSuperHero: GetSuperHeroUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadSuperHero(superHeroId: String) {
        _uiState.postValue(UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            val superHero = getSuperHero.invoke(superHeroId)
            _uiState.postValue(UiState(superHero = superHero))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val error: ErrorApp? = null,
        val superHero: SuperHero? = null
    )
}