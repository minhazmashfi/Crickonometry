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
import com.minhaz_uddin.crickonometry.adapter.FixtureAdapter
import com.minhaz_uddin.crickonometry.viewModel.CrickViewModel


class UpcomingMatchFragment : Fragment() {

   private lateinit var viewModel: CrickViewModel
   private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_upcoming_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this)[CrickViewModel::class.java]
        recyclerView=view.findViewById(R.id.recycler2)
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
//       viewModel.upcomingList.observe(viewLifecycleOwner){
//        recyclerView.adapter=FixtureAdapter(requireContext(),it.data,viewModel)
//     }

    }


}