package com.example.chapter24_25fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import com.example.chapter24_25fragments.databinding.ActivityMainActivity2ViewpagerBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity2_viewpager : AppCompatActivity() {

    var array= arrayOf("Home","notification","dashboard","hamburger","shop")
    private lateinit var viewPager2:ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var bottomNav: BottomNavigationView

    private lateinit var binding : ActivityMainActivity2ViewpagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainActivity2ViewpagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewPager2= binding.viewPager
        tabLayout= binding.tabLayout
        bottomNav= binding.navView2


        val viewpagerAdapter = viewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = viewpagerAdapter

        TabLayoutMediator(tabLayout,viewPager2){
            tab, position ->
            tab.text = array[position]
        }.attach()

        viewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bottomNav.menu.getItem(position).isChecked=true
            }
        })
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId)
            {
                R.id.home->{
                    viewPager2.currentItem=0
                    true
                }
                R.id.notification->{
                    viewPager2.currentItem=1
                    true
                }
                R.id.dashboard->{
                    viewPager2.currentItem=2
                    true
                }
                R.id.hamburger->{
                    viewPager2.currentItem=3
                    true
                }
                R.id.shop->{
                    viewPager2.currentItem=4
                    true
                }
            }
            false

            }
        }

    }
