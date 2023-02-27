package com.minhaz_uddin.crickonometry.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.minhaz_uddin.crickonometry.R


class HomeScreenFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rankingCard=view.findViewById<CardView>(R.id.rankingCard)
        val playersCard=view.findViewById<CardView>(R.id.players_card)
        rankingCard.setOnClickListener {
            val action=HomeFragmentDirections.actionHomeFragmentToRankingFragment()
            view.findNavController().navigate(action)
        }
        playersCard.setOnClickListener {
          findNavController().navigate(R.id.playersFragment)
        }
    }



}