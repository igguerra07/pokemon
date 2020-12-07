package br.com.igguerra.pokemonapp

import br.com.igguerra.pokemonapp.model.PokemonResult

interface PokemonContract {
    interface View {
        fun showPokemons(pokemonList: List<PokemonResult>)
    }

    interface Presenter {
        fun requestPokemon()
    }
}