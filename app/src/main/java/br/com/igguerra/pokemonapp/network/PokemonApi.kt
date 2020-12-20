package br.com.igguerra.pokemonapp.network

import br.com.igguerra.pokemonapp.model.PokemonDetailsResponse
import br.com.igguerra.pokemonapp.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
    fun getPokemons(
        @Query("offset") offset: String,
        @Query("limit") limit: String): Call<PokemonResponse>

    @GET("pokemon/{id}")
    fun getPokemonDetails(@Path("id") id: String): Call<PokemonDetailsResponse>
}