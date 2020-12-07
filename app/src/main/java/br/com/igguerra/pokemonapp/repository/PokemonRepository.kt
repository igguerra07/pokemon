package br.com.igguerra.pokemonapp.repository

import br.com.igguerra.pokemonapp.model.PokemonResponse
import retrofit2.Call

interface PokemonRepository {
    fun requestPokemons(offset: String, limit: String): Call<PokemonResponse>
}