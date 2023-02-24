package com.minhaz_uddin.crickonometry.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.minhaz_uddin.crickonometry.R
import com.minhaz_uddin.crickonometry.adapter.MatchViewPager
import com.minhaz_uddin.crickonometry.model.info.Batting
import com.minhaz_uddin.crickonometry.model.info.Lineup


class MatchFragment : Fragment() {
    lateinit var stage_name:String
    lateinit var venue_name:String
    lateinit var venue_city:String
    lateinit var momName:String
    lateinit var tosswon:String
    lateinit var leagueName:String
    lateinit var league_image:String
    lateinit var batting_score:List<Batting>
    lateinit var lineup:List<Lineup>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           stage_name=it.getString("stage_name","N/A")
            venue_name=it.getString("venue_name","N/A")
            momName=it.getString("mom","N/A")
            tosswon=it.getString("tosswon","N/A")
            leagueName=it.getString("league_name","N/A")
            league_image=it.getString("league_image","N/A")
            venue_city=it.getString("venue_city","N/A")
            batting_score=it.getParcelableArray("batting")!!.toList() as List<Batting>
            lineup=it.getParcelableArray("lineup")!!.toList() as List<Lineup>
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("info", "$lineup")
        super.onViewCreated(view, savedInstanceState)
        val TabLayout=view.findViewById<TabLayout>(R.id.tab_Layout)
        val viewPager2=view.findViewById<ViewPager2>(R.id.viewPager2)
        viewPager2.adapter=MatchViewPager(childFragmentManager,lifecycle,stage_name,venue_name,venue_city,momName,leagueName,league_image,tosswon,batting_score,lineup)
        TabLayoutMediator(TabLayout,viewPager2){ tab,position ->
            when(position){
                0 -> tab.text="Info"
                1 -> tab.text="Squad"
                2 -> tab.text = "ScoreCard"
            }

        }.attach()
    }



}