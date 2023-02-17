package com.minhaz_uddin.crickonometry.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.minhaz_uddin.crickonometry.R
import com.minhaz_uddin.crickonometry.model.fixture.FixtureData
import com.minhaz_uddin.crickonometry.viewModel.CrickViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class FixtureAdapter (private val context: Context,private val fixtures:List<FixtureData>,private val viewModel: CrickViewModel)
    :RecyclerView.Adapter<FixtureAdapter.FixtureViewHolder>() {
        class FixtureViewHolder(private val view:View):RecyclerView.ViewHolder(view){
            val localTeam=view.findViewById<ImageView>(R.id.local)
            val visitorTeam=view.findViewById<ImageView>(R.id.visitor)
            val team1=view.findViewById<TextView>(R.id.team1)
            val team2=view.findViewById<TextView>(R.id.team2)
            val result=view.findViewById<TextView>(R.id.result)
            val date=view.findViewById<TextView>(R.id.date)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureViewHolder {
        val adapterLayout= LayoutInflater.from(parent.context).inflate(R.layout.fixtures,parent,false)
        return FixtureViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: FixtureViewHolder, position: Int) {
        val item = fixtures[position]
        if (item.localteam_id != null && item.visitorteam_id != null) {
            GlobalScope.launch(Dispatchers.Default) {
                val team1 = viewModel.getTeamInfo(item.localteam_id!!)
                val team2 = viewModel.getTeamInfo(item.visitorteam_id!!)
                GlobalScope.launch(Dispatchers.Main) {
                    Glide.with(context).load(team1.image_path)
                        .centerCrop()
                        .into(holder.localTeam)
                    holder.team1.text=team1.code
                    holder.result.text=item.note
                    holder.team1
                    Glide.with(context)
                        .load(team2.image_path)
                        .centerCrop()
                        .into(holder.visitorTeam)
                    holder.team2.text=team2.code
                    holder.date.text=item.starting_at
                    holder.itemView.setOnClickListener {
                        holder.itemView.findNavController().navigate(R.id.matchFragment)
                    }

                }



            }
        }
    }


    override fun getItemCount(): Int {
        return fixtures.size
    }
}