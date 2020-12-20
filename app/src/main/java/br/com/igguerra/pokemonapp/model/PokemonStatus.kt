package br.com.igguerra.pokemonapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonStatus (
        @SerializedName("base_stat")
        val baseStat: Int,
        val effort: Int,
        val stat: PokemonApiResult
        ): Parcelable