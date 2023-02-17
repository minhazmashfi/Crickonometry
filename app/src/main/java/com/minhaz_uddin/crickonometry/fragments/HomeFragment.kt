package com.minhaz_uddin.crickonometry.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.minhaz_uddin.crickonometry.R
import com.minhaz_uddin.crickonometry.adapter.ViewPageAdapter


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabLayout=view.findViewById<TabLayout>(R.id.tab_layout)
        val viewPager=view.findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter=ViewPageAdapter(childFragmentManager,lifecycle)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text="Home"
                1 -> tab.text="Recent Matches"
                2 -> tab.text = "Upcoming matches"
            }
        }.attach()

    }



}