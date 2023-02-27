package com.minhaz_uddin.crickonometry.adapter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.minhaz_uddin.crickonometry.fragments.*
import com.minhaz_uddin.crickonometry.model.info.Batting
import com.minhaz_uddin.crickonometry.model.info.Lineup

class MatchViewPager(fragmentManager: FragmentManager, lifecycle: Lifecycle,val stage_name:String,val venue_name:String,val venue_city:String,val mom:String,val league_name:String,val league_image:String,val tosswon:String,val batting_score:List<Batting>,val lineup:List<Lineup>,val localTeam_id:Int,val visitorTeam_id:Int,val team1:String,val team2:String):
    FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        Log.d("matchinfo", "$localTeam_id")
        val bundle = Bundle()
        bundle.putString("stage_name", stage_name)
        bundle.putString("venue_name", venue_name)
        bundle.putString("venue_city",venue_city)
        bundle.putString("mom",mom)
        bundle.putString("league_name",league_name)
        bundle.putString("league_image",league_image)
        bundle.putString("tosswon",tosswon)

        return when(position){
            0 ->
                InfoFragment(bundle)
            1-> SquadFragment(lineup,localTeam_id,visitorTeam_id,team1,team2)
            2 -> ScoreCardFragment(batting_score,localTeam_id,visitorTeam_id,team1,team2)
            else -> Fragment()
        }
    }

}