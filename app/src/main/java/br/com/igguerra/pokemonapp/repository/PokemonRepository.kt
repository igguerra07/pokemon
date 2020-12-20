package br.com.igguerra.pokemonapp.repository

import br.com.igguerra.pokemonapp.model.PokemonDetailsResponse
import br.com.igguerra.pokemonapp.model.PokemonResponse
import retrofit2.Call

interface PokemonRepository {
    fun requestPokemons(offset: String, limit: String): Call<PokemonResponse>
    fun requestPokemon(id: String): Call<PokemonDetailsResponse>
}