package br.com.igguerra.pokemonapp.repository

import br.com.igguerra.pokemonapp.model.PokemonDetailsResponse
import br.com.igguerra.pokemonapp.model.PokemonResponse
import br.com.igguerra.pokemonapp.network.PokemonClient
import retrofit2.Call

class PokemonRepositoryImpl: PokemonRepository {
    override fun requestPokemons(offset: String, limit: String): Call<PokemonResponse> {
        return PokemonClient.providesApi().getPokemons(offset, limit)
    }

    override fun requestPokemon(id: String): Call<PokemonDetailsResponse> {
        return PokemonClient.providesApi().getPokemonDetails(id)
    }
}