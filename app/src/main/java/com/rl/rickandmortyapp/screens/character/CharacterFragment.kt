package com.rl.rickandmortyapp.screens.character

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.rl.rickandmortyapp.R
import com.rl.rickandmortyapp.database.DatabaseRoom
import com.rl.rickandmortyapp.databinding.FragmentCharacterBinding
/**
 * The character fragment
 */
class CharacterFragment : Fragment() {
    /**
     * On creation of the view we setup the binding, the adapter and the observers
     * @param inflater The inflater
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //get binding & inflate fragment
        val binding = DataBindingUtil.inflate<FragmentCharacterBinding>(
            inflater,
            R.layout.fragment_character, container, false
        )

        //set the menu to visible
        setHasOptionsMenu(true)

        val characterViewModel: CharacterViewModel by activityViewModels()


        //create and set the adapter
        val adapter = CharacterAdapter()
        binding.characterRecycler.adapter = adapter

        //set an observer for the characters in the viewmodel
        characterViewModel.characters.observe(viewLifecycleOwner, Observer {
            it?.let {
                //tell the adapter that the list has changed
                adapter.submitList(it)
            }
        })

        //set the current activity as the lifecycle owner of the binding
        // -> so that the binding can observe the livedata

        return binding.root
    }


    /**
     * Inflate the menu resource file
     *  @param menu The menu to inflate
     *  @param inflater The inflater to use
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    /**
     * Override to set the action on the menubuttons to their respective destination
     *  @param item The menu item that is selected
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}