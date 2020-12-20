package br.com.igguerra.pokemonapp.list

import android.util.Log
import br.com.igguerra.pokemonapp.model.PokemonDetailsResponse
import br.com.igguerra.pokemonapp.model.PokemonResponse
import br.com.igguerra.pokemonapp.repository.PokemonRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonListPresenter (
        private val view: PokemonListContract.View,
        private val repository: PokemonRepository) : PokemonListContract.Presenter {

    override fun requestPokemon() {
        val request = repository.requestPokemons("1", "150")

        request.enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
               if (response.isSuccessful && response.body() != null) {
                   view.showPokemons(response.body()!!.results)
                   return
               }
                Log.d("POKEAPI", "Erro na chamado")
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                Log.e("POKEAPI", t.message, t)
            }
        })
    }

    override fun onPokemonClick(id: String) {
        val request = repository.requestPokemon(id)

        request.enqueue(object : Callback<PokemonDetailsResponse> {
            override fun onResponse(call: Call<PokemonDetailsResponse>, response: Response<PokemonDetailsResponse>) {
                if(response.isSuccessful && response.body() != null) {
                    Log.d("POKEAPI", response.body().toString())
                    view.navToDetails(response.body()!!)
                    return
                }
                Log.d("POKEAPI", "Erro na chamado")
            }

            override fun onFailure(call: Call<PokemonDetailsResponse>, t: Throwable) {
                Log.e("POKEAPI", t.message, t)
            }
        })
    }
}