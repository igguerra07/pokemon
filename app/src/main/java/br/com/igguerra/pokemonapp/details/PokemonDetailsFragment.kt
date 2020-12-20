package br.com.igguerra.pokemonapp.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.igguerra.pokemonapp.R
import br.com.igguerra.pokemonapp.model.PokemonDetailsResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_pokemon_details.*

class PokemonDetailsFragment: Fragment(), PokemonDetailsContract.View {
    private lateinit var presenter: PokemonDetailsPresenter
    private var pokemonDetails: PokemonDetailsResponse? = null
    private lateinit var picasso: Picasso

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pokemon_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        picasso = Picasso.get()

        presenter = PokemonDetailsPresenter(this)

        arguments?.let {
            pokemonDetails = it.getParcelable(ARG_POKEMON_DETAILS)
        }

        pokemonDetails?.let { presenter.init(it) }
    }

    override fun showPokemonDetails(pokemonDetails: PokemonDetailsResponse) {
        picasso.load(pokemonDetails.sprites.front).into(pokemonDetailSprite)

        pokemonDetailName.text= pokemonDetails.name

        pokemonDetailTypeOne.text = pokemonDetails.types.first().type.name
        pokemonDetailTypeTwo.text = pokemonDetails.types.last().type.name

        pokemonDetailHpBar.progress = pokemonDetails.status.first().baseStat
    }

    companion object {
        const val POKEMON_DETAILS_FRAGMENT = "pokemonDetailsFragment"
        private const val ARG_POKEMON_DETAILS = "pokemonDetails"
        fun newInstance(pokemonDetails: PokemonDetailsResponse) =
        PokemonDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_POKEMON_DETAILS, pokemonDetails)
            }
        }
    }
}