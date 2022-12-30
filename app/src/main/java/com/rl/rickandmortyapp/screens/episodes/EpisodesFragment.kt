package com.rl.rickandmortyapp.screens.episodes

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.rl.rickandmortyapp.R
import com.rl.rickandmortyapp.databinding.FragmentEpisodesBinding
import com.rl.rickandmortyapp.databinding.FragmentHomepageBinding

class EpisodesFragment : Fragment() {

    private lateinit var viewModel: EpisodesViewModel
    private lateinit var binding: FragmentEpisodesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //instantiate the viewmodel for the episodes
        viewModel = ViewModelProvider(this).get(EpisodesViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_episodes,container,false)

        //set the menu to visible
        setHasOptionsMenu(true)

        //setup observer for episodes
        //setupObservers()

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

    /*private fun setupObservers()
    {
        /** Setting up LiveData observation relationship **/
        viewModel.episodes.observe(viewLifecycleOwner, Observer {
                //newEpisodes ->
            //binding. = newEpisodes
        })
    }*/
}