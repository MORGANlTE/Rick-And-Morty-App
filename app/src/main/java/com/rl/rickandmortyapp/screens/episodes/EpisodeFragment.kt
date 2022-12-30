package com.rl.rickandmortyapp.screens.episodes

import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.rl.rickandmortyapp.R
import com.rl.rickandmortyapp.databinding.FragmentEpisodesBinding
import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator

class EpisodeFragment : Fragment() {

    private lateinit var binding: FragmentEpisodesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //instantiate the viewmodel for the episodes

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_episodes,container,false)

        //create and set the adapter
        val adapter = EpisodeAdapter()
        binding.episodeRecycler.adapter = adapter

        //set an observer for the episodes in the viewmodel
        setupObserver(adapter)

        //set the menu to visible
        setHasOptionsMenu(true)

        setAnimations(adapter)
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

    private fun setupObserver(adapter: EpisodeAdapter)
    {
        val episodeViewModel: EpisodeViewModel by activityViewModels()

        episodeViewModel.episodes.observe(viewLifecycleOwner, Observer {
            it?.let {
                //tell the adapter that the list has changed
                adapter.submitList(it)
            }
        })
    }

    private fun setAnimations(adapter: EpisodeAdapter)
    {
        val recyclerView = binding.episodeRecycler
        recyclerView.itemAnimator = FadeInLeftAnimator()
    }


}