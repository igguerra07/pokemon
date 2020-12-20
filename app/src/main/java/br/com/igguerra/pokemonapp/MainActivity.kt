package br.com.igguerra.pokemonapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import br.com.igguerra.pokemonapp.list.PokemonListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openListFragment()
    }

    private fun openListFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, PokemonListFragment())
                .addToBackStack("pokemonList")
                .commit()
    }

    override fun onBackPressed() {
       // super.onBackPressed()
        val manager = supportFragmentManager
        try {

            val entry = manager.getBackStackEntryAt(manager.backStackEntryCount - 1)

            manager.popBackStack(entry.name, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}