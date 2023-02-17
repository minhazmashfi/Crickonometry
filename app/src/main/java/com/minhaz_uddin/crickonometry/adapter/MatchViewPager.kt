package com.minhaz_uddin.crickonometry.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.minhaz_uddin.crickonometry.fragments.*

class MatchViewPager(fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> InfoFragment()
            1-> SquadFragment()
            2 -> ScoreCardFragment()
            else -> Fragment()
        }
    }

}