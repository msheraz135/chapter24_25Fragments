package com.example.chapter24_25fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.chapter24_25fragments.fragments.HomeFragment
import com.example.chapter24_25fragments.fragments.chatFragment
import com.example.chapter24_25fragments.fragments.dashboardFragment
import com.example.chapter24_25fragments.fragments.hamburgerFragment
import com.example.chapter24_25fragments.fragments.shopFragment

private const val NUM_TABS = 5

class viewPagerAdapter(fragmentManager:FragmentManager,lifeCycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifeCycle) {
    override fun getItemCount(): Int {

        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {

        when(position) {
            0 -> return HomeFragment()
            1 -> return chatFragment()
            2 -> return dashboardFragment()
            3 -> return hamburgerFragment()
        }
        return shopFragment()
    }

}