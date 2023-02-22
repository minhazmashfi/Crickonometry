package com.minhaz_uddin.crickonometry.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.minhaz_uddin.crickonometry.R
import com.minhaz_uddin.crickonometry.fixtureDetails.Lineup
import java.util.zip.Inflater

class PlayerListAdapter(private val context:Context,private val squadPlayers:List<Lineup>):RecyclerView.Adapter<PlayerListAdapter.PlayerViewHolder>() {
      class PlayerViewHolder(private val view: View):RecyclerView.ViewHolder(view){
      val fullName=view.findViewById<TextView>(R.id.full_name)
      val image=view.findViewById<ImageView>(R.id.player_profile)
      }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val adapterLayout=
            LayoutInflater.from(parent.context).inflate(R.layout.players,parent,false)
        return PlayerViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val item=squadPlayers[position]
        holder.fullName.text=item.fullname!!
        Glide.with(context)
            .load(item.image_path)
            .centerCrop()
            .into(holder.image)

    }

    override fun getItemCount(): Int {
        return squadPlayers.size
    }
}