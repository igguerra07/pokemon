package br.com.igguerra.pokemonapp.list

import br.com.igguerra.pokemonapp.model.PokemonApiResult
import br.com.igguerra.pokemonapp.model.PokemonDetailsResponse

interface PokemonListContract {
    interface View {
        fun showPokemons(pokemonList: List<PokemonApiResult>)
        fun navToDetails(pokemon: PokemonDetailsResponse)
    }

    interface Presenter {
        fun requestPokemon()
        fun onPokemonClick(id: String)
    }}