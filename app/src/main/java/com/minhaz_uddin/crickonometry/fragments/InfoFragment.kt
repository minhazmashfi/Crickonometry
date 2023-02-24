package com.minhaz_uddin.crickonometry.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.minhaz_uddin.crickonometry.R

private const val TAG = "InfoFragment"
class InfoFragment(
    val bundle: Bundle) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val league_image=view.findViewById<ImageView>(R.id.league_image)
        val stage_name=view.findViewById<TextView>(R.id.stage)
        val venue_name=view.findViewById<TextView>(R.id.venue)
        val venue_city=view.findViewById<TextView>(R.id.city)
        val mom=view.findViewById<TextView>(R.id.mom)
        val league_name=view.findViewById<TextView>(R.id.league_name)
        val tosswon=view.findViewById<TextView>(R.id.toss)

        stage_name.text="Tour: ${bundle.getString("stage_name")}"
        venue_name.text="Venue: ${bundle.getString("venue_name")}"
        venue_city.text="Location: ${bundle.getString("venue_city")}"
        mom.text="Man Of the Match: ${bundle.getString("mom")}"
        league_name.text="League: ${bundle.getString("league_name")}"
        tosswon.text="Toss Result: ${bundle.getString("tosswon")}"

        Glide.with(requireContext())
            .load(bundle.getString("league_image"))
            .circleCrop()
            .into(league_image)
       
    }


}