package com.minhaz_uddin.crickonometry.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minhaz_uddin.crickonometry.R
import com.minhaz_uddin.crickonometry.adapter.ScoreCardAdapter
import com.minhaz_uddin.crickonometry.model.info.Batting
import com.minhaz_uddin.crickonometry.viewModel.CrickViewModel


class ScoreCardFragment(val batting_score:List<Batting>,val localTeam_id:Int,val visitorTeam_id:Int,val team1:String,val team2:String) : Fragment() {
    private lateinit var viewModel: CrickViewModel
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_score_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[CrickViewModel::class.java]
        Log.d("batsman", "$batting_score ")
            val battingList1 = mutableListOf<Batting>()
            val battingList2 = mutableListOf<Batting>()
            val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)
            val card=view.findViewById<CardView>(R.id.cardView)
            val localTeam = view.findViewById<RadioButton>(R.id.local_team)
            val visitorTeam = view.findViewById<RadioButton>(R.id.visitor_team)

            localTeam.text = team1
            visitorTeam.text = team2
            for (batting in batting_score) {
                if (batting.team_id == localTeam_id) {
                    battingList1.add(batting)
                }
                if (batting.team_id==visitorTeam_id){
                    battingList2.add(batting)
                }
            }

            recyclerView = view.findViewById(R.id.recycler_score)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            radioGroup.setOnCheckedChangeListener { group, checkedId ->
                if (checkedId == (R.id.local_team)) {
                    recyclerView.adapter = ScoreCardAdapter(requireContext(), battingList1)
                    card.visibility=View.VISIBLE

                }
                if(checkedId==(R.id.visitor_team)){
                    recyclerView.adapter = ScoreCardAdapter(requireContext(), battingList2)
                    card.visibility=View.VISIBLE
                }
            }
        }
    }






