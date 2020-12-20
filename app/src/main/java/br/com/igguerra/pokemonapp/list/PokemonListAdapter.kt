package br.com.igguerra.pokemonapp.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igguerra.pokemonapp.R
import br.com.igguerra.pokemonapp.model.PokemonApiResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonListAdapter(private val pokemons: List<PokemonApiResult>, private val onItemClick: (PokemonApiResult) -> Unit): RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int = pokemons.size

    inner class PokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.pokemonName
        private val img = itemView.pokemonImg

        fun bind(pokemon: PokemonApiResult) {
            name.text = pokemon.name
            Picasso.get().load(pokemon.img).into(img)
            itemView.setOnClickListener { onItemClick(pokemon) }
        }
    }
}