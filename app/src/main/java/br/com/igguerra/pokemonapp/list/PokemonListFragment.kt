package br.com.igguerra.pokemonapp.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.igguerra.pokemonapp.R
import br.com.igguerra.pokemonapp.details.PokemonDetailsFragment
import br.com.igguerra.pokemonapp.model.PokemonApiResult
import br.com.igguerra.pokemonapp.model.PokemonDetailsResponse
import br.com.igguerra.pokemonapp.repository.PokemonRepositoryImpl
import kotlinx.android.synthetic.main.fragment_pokemon_list.*

class PokemonListFragment : Fragment(), PokemonListContract.View {
    private val pokemons: ArrayList<PokemonApiResult> = arrayListOf()

    private lateinit var pokemonAdapter: PokemonListAdapter

    private lateinit var presenter: PokemonListContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = PokemonListPresenter(this, PokemonRepositoryImpl())

        pokemonAdapter = PokemonListAdapter(pokemons) { presenter.onPokemonClick(it.id) }

        setupAdapter()

        presenter.requestPokemon()
    }

    private fun setupAdapter() {
        pokemonListRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            hasFixedSize()
            adapter = pokemonAdapter
        }
    }

    private fun updatePokemons(data: List<PokemonApiResult>) {
        pokemons.clear()
        pokemons.addAll(data)
        pokemonAdapter.notifyDataSetChanged()
    }

    override fun showPokemons(pokemonList: List<PokemonApiResult>) {
        updatePokemons(pokemonList)
    }

    override fun navToDetails(pokemon: PokemonDetailsResponse) {
        val fragment = PokemonDetailsFragment.newInstance(pokemon)
        fragmentManager!!
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(PokemonDetailsFragment.POKEMON_DETAILS_FRAGMENT)
                .commit()
    }
}