package com.rl.rickandmortyapp.screens.episodes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.rl.rickandmortyapp.R
import com.rl.rickandmortyapp.databinding.FragmentEpisodesBinding
import com.rl.rickandmortyapp.databinding.FragmentHomepageBinding

class EpisodesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentEpisodesBinding>(inflater,
            R.layout.fragment_episodes,container,false)

        return binding.root
    }
}