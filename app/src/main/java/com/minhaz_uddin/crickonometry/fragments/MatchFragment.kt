package com.minhaz_uddin.crickonometry.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.minhaz_uddin.crickonometry.R
import com.minhaz_uddin.crickonometry.adapter.MatchViewPager
import kotlinx.android.synthetic.main.fragment_match.*


class MatchFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val TabLayout=view.findViewById<TabLayout>(R.id.tab_Layout)
        val viewPager2=view.findViewById<ViewPager2>(R.id.viewPager2)
        viewPager2.adapter=MatchViewPager(childFragmentManager,lifecycle)
        TabLayoutMediator(TabLayout,viewPager2){ tab,position ->
            when(position){
                0 -> tab.text="Info"
                1 -> tab.text="Squad"
                2 -> tab.text = "ScoreCard"
            }

        }.attach()
    }



}