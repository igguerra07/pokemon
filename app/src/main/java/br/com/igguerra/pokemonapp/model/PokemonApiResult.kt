package br.com.igguerra.pokemonapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonApiResult (
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
): Parcelable {

    val id: String get() = url.split("/".toRegex()).dropLast(1).last()

    val img: String get() = "https://pokeres.bastionbot.org/images/pokemon/$id.png"
}