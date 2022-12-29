package com.rl.rickandmortyapp.screens.characters

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.rl.rickandmortyapp.R
import com.rl.rickandmortyapp.database.CharacterDatabase
import com.rl.rickandmortyapp.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {

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

        //get the application context
        val application = requireNotNull(this.activity).application
        // get/create the db
        val dataSouce = CharacterDatabase.getInstance(application).characterDatabaseDao
        //create an instance of the ViewModel factory
        val viewModelFactory = CharacterViewModelFactory(dataSouce, application)

        //get the viewmodel
        val characterViewModel =
            ViewModelProvider(this, viewModelFactory).get(CharacterViewModel::class.java)
        //testen of t werkt
        characterViewModel.logIets()

        //create and set the adapter
        val adapter = CharacterAdapter()
        binding.characterRecycler.adapter = adapter


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