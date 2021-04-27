package com.example.ioasys.sections.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import com.example.ioasys.R
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    private val navController by lazy { findNavController(R.id.nav_host_fragment) }
    private val currentFragment: Fragment
        get() = checkNotNull(supportFragmentManager.fragments.firstOrNull()?.childFragmentManager?.primaryNavigationFragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onBackPressed() {
        if (currentFragment is ListFragment) finish()
        else navController.popBackStack()
    }
}