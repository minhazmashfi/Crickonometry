package com.minhaz_uddin.crickonometry.adapter

import android.content.Context
import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.minhaz_uddin.crickonometry.R
import com.minhaz_uddin.crickonometry.model.ranking.Team


class IntlTeamAdapter(private val context: Context,private val teamList: List<Team>):RecyclerView.Adapter<IntlTeamAdapter.IntlTeamViewHolder>() {
    class IntlTeamViewHolder(private val view:View):RecyclerView.ViewHolder(view){
        val country=view.findViewById<TextView>(R.id.country)
        val code=view.findViewById<TextView>(R.id.code)
        val rating=view.findViewById<TextView>(R.id.rating)
        val position=view.findViewById<TextView>(R.id.position)
        val image=view.findViewById<ImageView>(R.id.countryImage)
        val points=view.findViewById<TextView>(R.id.points)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntlTeamViewHolder {
        val adapterLayout=LayoutInflater.from(parent.context).inflate(R.layout.intl_teams,parent,false)
        return IntlTeamViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: IntlTeamViewHolder, position: Int) {
       val item=teamList[position]
       holder.country.text=item.name
       holder.position.text="Position:${item.ranking.position.toString()}"
       holder.rating.text="Rating:${item.ranking.rating.toString()}"
       holder.code.text=item.code
        holder.points.text="Points:${item.ranking.points.toString()}"
       Glide.with(context)
           .load(item.image_path)
           .centerCrop()
           .into(holder.image)



    }

    override fun getItemCount(): Int {
        return teamList.size
    }
}