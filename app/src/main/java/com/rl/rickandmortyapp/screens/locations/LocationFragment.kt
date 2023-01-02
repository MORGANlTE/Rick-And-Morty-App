package com.rl.rickandmortyapp.screens.locations

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.rl.rickandmortyapp.R
import com.rl.rickandmortyapp.databinding.FragmentLocationBinding
import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator

/**
 * The locations fragment
 */
class LocationFragment : Fragment() {
    private lateinit var binding: FragmentLocationBinding
    /**
     * On creation of the view we setup the binding, the adapter, the observers and the animations
     * @param inflater The inflater
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //set the menu to visible
        setHasOptionsMenu(true)

        //instantiate the viewmodel for the episodes
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_location,container,false)



        //create and set the adapter
        val adapter = LocationAdapter()
        binding.locationRecycler.adapter = adapter

        //set an observer for the locations in the viewmodel
        setupObserver(adapter)



        setAnimations()


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
     * Sets up the observer to observe the location changes
     *  @param adapter The adapter to with the locations
     */
    private fun setupObserver(adapter: LocationAdapter)
    {
        val locationViewModel: LocationViewModel by activityViewModels()

        locationViewModel.locations.observe(viewLifecycleOwner, Observer {
            it?.let {
                //tell the adapter that the list has changed
                adapter.submitList(it)
            }
        })
    }
    /**
     * Set the animation for the recyclerview (maybe animations more in the future)
     */
    private fun setAnimations()
    {
        val recyclerView = binding.locationRecycler
        recyclerView.itemAnimator = FadeInLeftAnimator()
    }
}