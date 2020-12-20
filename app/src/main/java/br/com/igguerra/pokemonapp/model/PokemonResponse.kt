package br.com.igguerra.pokemonapp.model

data class PokemonResponse (
    val count: Int,
    val next: String = "",
    val previous: String = "",
    val results: List<PokemonApiResult>
        )