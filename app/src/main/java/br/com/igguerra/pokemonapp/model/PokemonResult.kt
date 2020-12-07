package br.com.igguerra.pokemonapp.model

import com.google.gson.annotations.SerializedName

data class PokemonResult (
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
) {
    fun getImageUrl(): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://pokeres.bastionbot.org/images/pokemon/$index.png"
    }
}