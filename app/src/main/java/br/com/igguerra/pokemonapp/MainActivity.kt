package br.com.igguerra.pokemonapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.igguerra.pokemonapp.model.PokemonResult
import br.com.igguerra.pokemonapp.repository.PokemonRepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PokemonContract.View {

    private val pokemons: ArrayList<PokemonResult> = arrayListOf()
    private lateinit var pokemonAdapter: PokemonAdapter
    private lateinit var presenter: PokemonContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = PokemonPresenter(this, PokemonRepositoryImpl())

        pokemonAdapter = PokemonAdapter(pokemons)

        setupAdapter()

        presenter.requestPokemon()
    }

    private fun setupAdapter() {
        pokemonList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()
            adapter = pokemonAdapter
        }
    }

    private fun updatePokemons(data: List<PokemonResult>) {
        pokemons.clear()
        pokemons.addAll(data)
        pokemonAdapter.notifyDataSetChanged()
    }

    override fun showPokemons(pokemonList: List<PokemonResult>) {
        updatePokemons(pokemonList)
    }
}