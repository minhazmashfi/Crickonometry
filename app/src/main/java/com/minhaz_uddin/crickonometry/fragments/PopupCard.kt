package com.minhaz_uddin.crickonometry.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.minhaz_uddin.crickonometry.R

class PopupCard(val playerName:String,val dob:String,val batting_style:String,val bowling_style:String,val image:String) : DialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popup_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button1=view.findViewById<Button>(R.id.button)
        val player_name=view.findViewById<TextView>(R.id.player_Name)
        val player_dob=view.findViewById<TextView>(R.id.d_o_b)
        val battingStyle=view.findViewById<TextView>(R.id.batting_Style)
        val bowlingStyle=view.findViewById<TextView>(R.id.bowling_Style)
        val player_image=view.findViewById<ImageView>(R.id.player_Image)
        player_name.text="Name: $playerName"
        player_dob.text="Date Of Birth : $dob"
        battingStyle.text="Batting_style: ${batting_style}"
        bowlingStyle.text="Bowling_style: $bowling_style"
        Log.d("images", "$image")
        if (image!=null) {
            Glide.with(requireContext())
                .load(image)
                .circleCrop()
                .into(player_image)
        }

        button1.setOnClickListener {
            dismiss()
        }
    }


}