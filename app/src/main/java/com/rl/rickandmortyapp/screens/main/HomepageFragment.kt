package com.rl.rickandmortyapp.screens.main


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
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

        return binding.root
    }

    private fun setupButtons() {

        //OnclickListener for the button to the episodes
        binding.episodesButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homepageFragment_to_episodesFragment)
        }
    }

}