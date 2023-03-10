package com.rl.rickandmortyapp.screens.main


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.rl.rickandmortyapp.R
import com.rl.rickandmortyapp.databinding.FragmentHomepageBinding


class HomepageFragment : Fragment() {

    private lateinit var binding: FragmentHomepageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_homepage, container, false
        )
        //set the onclick listeners for the buttons
        setupButtons()

        //set the menu to visible
        setHasOptionsMenu(true)
        return binding.root
    }

   /**
    * Inflate the menu with the inflater
    * @param menu The menu to inflate
    * @param inflater The inflater to give to the menu
    */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    /**
     * Override to set the action on the menubuttons to their respective destination
     *  @param item Item that is selected
    */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    /**
     * sets up all the listeners for the buttons
     */
    private fun setupButtons() {

        //OnclickListener for the button to the episodes
        binding.episodesButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homepageFragment_to_episodesFragment)
        }

        //OnclickListener for the button to the characters
        binding.charactersButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_homepageFragment_to_characterFragment)
        }

        //OnclickListener for the button to the locations
        binding.locationsButton.setOnClickListener {  view: View ->
            view.findNavController().navigate(R.id.action_homepageFragment_to_locationFragment)
        }

    }

}