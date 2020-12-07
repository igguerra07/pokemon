package br.com.igguerra.pokemonapp.network

import br.com.igguerra.pokemonapp.application.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonClient {
    private fun providesRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun providesApi(): PokemonApi {
        val client = providesRetrofitClient()
        return client.create(PokemonApi::class.java)
    }
}