package br.com.igguerra.pokemonapp.details

import br.com.igguerra.pokemonapp.model.PokemonDetailsResponse

class PokemonDetailsPresenter(private val view: PokemonDetailsContract.View): PokemonDetailsContract.Presenter {
    override fun init(pokemonDetails: PokemonDetailsResponse) {
        view.showPokemonDetails(pokemonDetails)
    }
}