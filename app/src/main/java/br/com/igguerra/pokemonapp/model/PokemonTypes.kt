package br.com.igguerra.pokemonapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonTypes(val slot: Int, val type: PokemonApiResult): Parcelable