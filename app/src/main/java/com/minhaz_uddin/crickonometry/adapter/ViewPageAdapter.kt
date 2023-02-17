package com.minhaz_uddin.crickonometry.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.minhaz_uddin.crickonometry.fragments.HomeFragment
import com.minhaz_uddin.crickonometry.fragments.HomeScreenFragment
import com.minhaz_uddin.crickonometry.fragments.Recent_MatchFragment
import com.minhaz_uddin.crickonometry.fragments.UpcomingMatchFragment

class ViewPageAdapter(fragmentManager: FragmentManager,lifecycle:Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
            0 -> HomeScreenFragment()
            1->Recent_MatchFragment()
            2 ->UpcomingMatchFragment()
            else ->Fragment()
        }
    }

}