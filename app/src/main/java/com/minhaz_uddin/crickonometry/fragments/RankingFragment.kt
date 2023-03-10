package com.minhaz_uddin.crickonometry.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minhaz_uddin.crickonometry.R
import com.minhaz_uddin.crickonometry.adapter.IntlTeamAdapter
import com.minhaz_uddin.crickonometry.viewModel.CrickViewModel


class RankingFragment : Fragment() {

   private lateinit var viewModel: CrickViewModel
   private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ranking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this)[CrickViewModel::class.java]
        recyclerView=view.findViewById(R.id.recyclerrank)
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        viewModel.rankingList.observe(viewLifecycleOwner){
            recyclerView.adapter=IntlTeamAdapter(requireContext(),it[0].team)
       }
   }


}