package com.minhaz_uddin.crickonometry.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
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
        val searchbar = view.findViewById<SearchView>(R.id.search_bar)
        recyclerView = view.findViewById(R.id.recyclerPlayers)
        viewModel = ViewModelProvider(this)[CrickViewModel::class.java]
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.readAllPlayers.observe(viewLifecycleOwner){
            recyclerView.adapter = PlayerListAdapter(requireContext(), it)
        }
        searchbar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val searchList = mutableListOf<Lineup>()
                viewModel.readAllPlayers.observe(viewLifecycleOwner) {
                    for (lineup in it) {
                        if (lineup.fullname.contains(query!!, ignoreCase = true)) {
                            searchList.add(lineup)
                        }
                    }

                }
                recyclerView.adapter = PlayerListAdapter(requireContext(), searchList)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    viewModel.readAllPlayers.observe(viewLifecycleOwner) {
                        recyclerView.adapter = PlayerListAdapter(requireContext(), it)
                    }

                }
                return true
            }
        })
    }
}















