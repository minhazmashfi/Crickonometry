package com.minhaz_uddin.crickonometry.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.minhaz_uddin.crickonometry.R
import com.minhaz_uddin.crickonometry.model.info.Lineup

class SquadAdapter(private val context: Context,val Lineup:List<Lineup>):RecyclerView.Adapter<SquadAdapter.SquadViewHolder>() {

    class SquadViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val player_image=view.findViewById<ImageView>(R.id.player_image)
        val player_name=view.findViewById<TextView>(R.id.player_name)
        val batting_style=view.findViewById<TextView>(R.id.batting_style)
        val bowling_style=view.findViewById<TextView>(R.id.bowling_style)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SquadViewHolder {
        val adapterLayout= LayoutInflater.from(parent.context).inflate(R.layout.squad_list,parent,false)
        return SquadViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: SquadViewHolder, position: Int) {
        val item=Lineup[position]
        holder.player_name.text=item.fullname
        holder.batting_style.text=item.battingstyle
        holder.bowling_style.text=item.bowlingstyle
        Glide.with(context)
            .load(item.image_path)
            .centerCrop()
            .into(holder.player_image)
    }

    override fun getItemCount(): Int {
        return Lineup.size
    }

}