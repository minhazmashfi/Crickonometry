package com.minhaz_uddin.crickonometry.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minhaz_uddin.crickonometry.R
import com.minhaz_uddin.crickonometry.adapter.ScoreCardAdapter
import com.minhaz_uddin.crickonometry.adapter.SquadAdapter
import com.minhaz_uddin.crickonometry.model.info.Lineup


class SquadFragment(val lineup:List<Lineup>,val localTeam_id:Int,val visitorTeam_id:Int,val team1:String,val team2:String) : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_squad, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lineupList1= mutableListOf<Lineup>()
        val lineupList2= mutableListOf<Lineup>()
        recyclerView=view.findViewById(R.id.recycler_squad)
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        val radioGroup=view.findViewById<RadioGroup>(R.id.radioGroup2)
        val localTeam=view.findViewById<RadioButton>(R.id.local_team2)
        val visitorTeam=view.findViewById<RadioButton>(R.id.visitor_team2)
        val card=view.findViewById<CardView>(R.id.cardView2)
        val team_name=view.findViewById<TextView>(R.id.team_name)
        localTeam.text=team1
        visitorTeam.text=team2
        for (lineup in lineup) {
            if (lineup.lineup?.team_id == localTeam_id) {
                lineupList1.add(lineup)
            }
            if (lineup.lineup?.team_id==visitorTeam_id){
                lineupList2.add(lineup)
            }
        }
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == (R.id.local_team2)) {
                recyclerView.adapter = SquadAdapter(requireContext(), lineupList1)
                card.visibility=View.VISIBLE
                team_name.text=team1
            }
            if(checkedId==(R.id.visitor_team2)){
                recyclerView.adapter = SquadAdapter(requireContext(), lineupList2)
                card.visibility=View.VISIBLE
                team_name.text=team2
            }
        }
    }



}