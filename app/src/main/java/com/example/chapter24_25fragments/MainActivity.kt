package com.example.chapter24_25fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.chapter24_25fragments.databinding.ActivityMainBinding
import com.example.chapter24_25fragments.fragments.HomeFragment
import com.example.chapter24_25fragments.fragments.chatFragment
import com.example.chapter24_25fragments.fragments.dashboardFragment
import com.example.chapter24_25fragments.fragments.hamburgerFragment
import com.example.chapter24_25fragments.fragments.notificationFragment
import com.example.chapter24_25fragments.fragments.shopFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.google.android.material.tabs.TabLayout.LabelVisibility

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView:BottomNavigationView = binding.navView
        navView.labelVisibilityMode= BottomNavigationView.LABEL_VISIBILITY_LABELED

        // Set up fragment container (assuming there's a suitable FrameLayout in your layout)
        val fragmentContainer = findViewById<FrameLayout>(R.id.nav_host_fragment)
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    switchFragment(fragmentContainer, HomeFragment())
                    true
                }
                R.id.dashboard ->{
                    switchFragment(fragmentContainer, dashboardFragment())
                    true
                }
                R.id.hamburger->{
                    switchFragment(fragmentContainer, hamburgerFragment())
                    true
                }
                R.id.shop-> {
                    switchFragment(fragmentContainer, shopFragment())
                    true
                }
                R.id.notification ->{
                        switchFragment(fragmentContainer, notificationFragment())
                        true
                    }
            }
            false
        }
        switchFragment( fragmentContainer, HomeFragment())

    }

    private fun switchFragment(container: ViewGroup, fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(container.id, fragment)
        fragmentTransaction.commit()
    }
}