package com.rl.rickandmortyapp.screens.locations

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.rl.rickandmortyapp.R
import com.rl.rickandmortyapp.databinding.FragmentEpisodesBinding
import com.rl.rickandmortyapp.databinding.FragmentLocationBinding
import com.rl.rickandmortyapp.screens.episodes.EpisodesViewModel

class LocationFragment : Fragment() {
    private lateinit var viewModel: LocationViewModel
    private lateinit var binding: FragmentLocationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //instantiate the viewmodel for the episodes
        viewModel = ViewModelProvider(this).get(LocationViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_location,container,false)

        //set the menu to visible
        setHasOptionsMenu(true)

        return binding.root
    }
    //inflate the menu resource file
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    //override to set the action on the menubuttons to their respective destination
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}