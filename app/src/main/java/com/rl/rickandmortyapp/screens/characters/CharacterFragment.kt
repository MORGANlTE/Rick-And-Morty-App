package com.rl.rickandmortyapp.screens.characters

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.rl.rickandmortyapp.R
import com.rl.rickandmortyapp.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {

    lateinit var characterViewModel: CharacterViewModel

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

        //get the viewmodel
        val vm: CharacterViewModel by activityViewModels()
        //set the viewmodel
        characterViewModel = vm

        characterViewModel.logIets()

        return binding.root
    }

    //inflate the menu resource file
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    //override to set the action on the menubuttons to their respective destination
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}