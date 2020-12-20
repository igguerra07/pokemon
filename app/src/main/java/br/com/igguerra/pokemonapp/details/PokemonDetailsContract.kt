package br.com.igguerra.pokemonapp.details

import br.com.igguerra.pokemonapp.model.PokemonDetailsResponse

interface PokemonDetailsContract {
    interface View {
        fun showPokemonDetails(pokemonDetails: PokemonDetailsResponse)
    }
    interface Presenter {
        fun init(pokemonDetails: PokemonDetailsResponse)
    }
}