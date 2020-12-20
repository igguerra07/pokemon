package br.com.igguerra.pokemonapp.network

import br.com.igguerra.pokemonapp.application.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonClient {
    private fun providesClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun providesApi(): PokemonApi {
        val client = providesClient()
        return client.create(PokemonApi::class.java)
    }
}