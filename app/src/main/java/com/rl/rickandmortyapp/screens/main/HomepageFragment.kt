package com.rl.rickandmortyapp.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.rl.rickandmortyapp.R
import com.rl.rickandmortyapp.databinding.FragmentHomepageBinding

class HomepageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentHomepageBinding>(inflater,
            R.layout.fragment_homepage,container,false)
        return binding.root
    }

}