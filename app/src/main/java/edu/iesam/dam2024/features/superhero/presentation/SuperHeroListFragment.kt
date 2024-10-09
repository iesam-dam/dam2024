package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.iesam.dam2024.databinding.FragmentMoviesBinding
import edu.iesam.dam2024.databinding.FragmentSuperheroListBinding

class SuperHeroListFragment : Fragment() {

    private var _binding: FragmentSuperheroListBinding? = null
    private val binding get() = _binding!!

    private lateinit var factory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroListViewModel

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
        val observer = Observer<SuperHeroListViewModel.UiState>{
            //código de respuesta
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }
}