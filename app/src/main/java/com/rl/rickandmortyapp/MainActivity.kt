package com.rl.rickandmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.rl.rickandmortyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //find the nav controller for future navigation settings etc.
        val navController = findNavController(R.id.myNavHostFragment)

        //setup the top left action bar
        NavigationUI.setupActionBarWithNavController(this,navController)

        navController.navigate(R.id.homepageFragment)
    }
    //overwriting the back button for our navhost
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}