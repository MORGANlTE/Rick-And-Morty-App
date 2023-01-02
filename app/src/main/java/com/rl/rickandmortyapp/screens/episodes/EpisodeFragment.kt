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
/**
 * The episodes fragment
 */
class EpisodeFragment : Fragment() {

    private lateinit var binding: FragmentEpisodesBinding

    /**
     * On creation of the view we setup the binding, the adapter, the observers and the animations
     * @param inflater The inflater
     */
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
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    /**
     * Sets up the observer to observe the episode changes
     *  @param adapter The adapter to with the episodes
     */
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

    /**
     * Set the animation for the recyclerview
     */
    private fun setAnimations(adapter: EpisodeAdapter)
    {
        val recyclerView = binding.episodeRecycler
        recyclerView.itemAnimator = FadeInLeftAnimator()
    }


}