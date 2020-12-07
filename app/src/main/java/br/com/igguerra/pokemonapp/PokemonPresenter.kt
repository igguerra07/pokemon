package br.com.igguerra.pokemonapp

import android.util.Log
import br.com.igguerra.pokemonapp.model.PokemonResponse
import br.com.igguerra.pokemonapp.repository.PokemonRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonPresenter(private val view: PokemonContract.View, private val repository: PokemonRepository): PokemonContract.Presenter {
    override fun requestPokemon() {
        val request = repository.requestPokemons("150", "150")

        request.enqueue(object: Callback<PokemonResponse> {
            override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d("POKEMIRO", response.body().toString())
                    view.showPokemons(response.body()!!.results)
                    return
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                Log.e("POKEMIRO", t.message, t)
            }
        })
    }
}