package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.app.presentation.hide
import edu.iesam.dam2024.app.presentation.views.ErrorAppUIFactory
import edu.iesam.dam2024.databinding.FragmentMoviesBinding
import edu.iesam.dam2024.databinding.FragmentSuperheroListBinding
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroListFragment : Fragment() {

    private var _binding: FragmentSuperheroListBinding? = null
    private val binding get() = _binding!!

    private lateinit var factory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroListViewModel

    //
    //var errorFactory : ErrorAppUIFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = SuperHeroFactory()
        viewModel = factory.getSuperHeroListViewModel()
        setupObserver()
        viewModel.loadSuperHeroes()
    }

    private fun setupObserver(){
        val observer = Observer<SuperHeroListViewModel.UiState>{ uiState ->
            //código de respuesta
            uiState.superHeroes?.let { superHeroes ->
                bindData(superHeroes)
            }

            uiState.errorApp?.let {
                //Pinto el error
                val error = ErrorAppUIFactory(requireContext())
                val errorAppUI = error.build(it)
                binding.errorApp.render(errorAppUI)
            } ?: run {
                binding.errorApp.hide()
            }

            if (uiState.isLoading){
                //Muestro cargando...
            } else {
                //Oculto el cargando...
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun bindData(superHeroes: List<SuperHero>){
        binding.apply {
            superhero1.apply {
                text = superHeroes[0].name
                setOnClickListener {
                    navigateToDetails(superHeroes[0].id)
                }
            }

            superhero2.text = superHeroes[1].name
            superhero2.setOnClickListener {
                navigateToDetails(superHeroes[1].id)
            }

            superhero3.text = superHeroes[2].name
            superhero3.setOnClickListener {
                navigateToDetails(superHeroes[2].id)
            }
        }
    }

    private fun navigateToDetails(superHeroId: String){
        findNavController().navigate(SuperHeroListFragmentDirections
            .actionFromSuperheroToSuperheroDetail(superHeroId)
        )
    }
}