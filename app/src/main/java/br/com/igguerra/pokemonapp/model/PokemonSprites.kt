package br.com.igguerra.pokemonapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonSprites (
        @SerializedName("front_default")
        val front: String
): Parcelable