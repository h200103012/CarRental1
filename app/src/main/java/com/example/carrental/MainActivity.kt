package com.example.carrental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.carrental.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView




class   MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        APP = this



//        navController = Navigation.findNavController(this,R.id.mainNavFragment)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainNavFragment) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)
    }
}


