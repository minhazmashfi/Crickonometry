package com.minhaz_uddin.crickonometry.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minhaz_uddin.crickonometry.R
import com.minhaz_uddin.crickonometry.adapter.PlayerListAdapter
import com.minhaz_uddin.crickonometry.fixtureDetails.Lineup
import com.minhaz_uddin.crickonometry.viewModel.CrickViewModel

class PlayersFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: CrickViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerPlayers)
        viewModel = ViewModelProvider(this)[CrickViewModel::class.java]
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val playerList = mutableSetOf<Lineup>()
        viewModel.fixtureDlList.observe(viewLifecycleOwner) { it ->
            it?.let { it ->
                it.data.forEach {
                    it.lineup.forEach {
                        playerList.add(it)
                    }
                }
                Log.d("lineup", "$playerList")
            }


            recyclerView.adapter = PlayerListAdapter(requireContext(), playerList)
        }

    }


}