package com.minhaz_uddin.crickonometry.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.minhaz_uddin.crickonometry.R
import com.minhaz_uddin.crickonometry.fragments.HomeFragmentDirections

import com.minhaz_uddin.crickonometry.model.info.FixtureInfoData

import com.minhaz_uddin.crickonometry.viewModel.CrickViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class FixtureAdapter (private val context: Context, private val fixtures:List<FixtureInfoData>, private val viewModel: CrickViewModel)
    :RecyclerView.Adapter<FixtureAdapter.FixtureViewHolder>() {
        class FixtureViewHolder(private val view:View):RecyclerView.ViewHolder(view){
            val localTeam=view.findViewById<ImageView>(R.id.local)
            val visitorTeam=view.findViewById<ImageView>(R.id.visitor)
            val team1=view.findViewById<TextView>(R.id.team1)
            val team2=view.findViewById<TextView>(R.id.team2)
            val result=view.findViewById<TextView>(R.id.result)
            val date=view.findViewById<TextView>(R.id.date)
            val time=view.findViewById<TextView>(R.id.time)
            val run1=view.findViewById<TextView>(R.id.run1)
            val run2=view.findViewById<TextView>(R.id.run2)
            val over1=view.findViewById<TextView>(R.id.overs1)
            val overs2=view.findViewById<TextView>(R.id.overs2)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureViewHolder {
        val adapterLayout= LayoutInflater.from(parent.context).inflate(R.layout.fixtures,parent,false)
        return FixtureViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: FixtureViewHolder, position: Int) {
        val item = fixtures[position]
        Log.d("problem", "${item.runs}")
        if (item.localteam_id != null && item.visitorteam_id != null ) {
            GlobalScope.launch(Dispatchers.Default) {
                val team1 = viewModel.getTeamInfo(item.localteam_id!!)
                val team2 = viewModel.getTeamInfo(item.visitorteam_id!!)
                val runteam1=item.runs?.get(0)?.team_id
                val runteam2=item.runs?.get(1)?.team_id

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
                    if (item.runs?.get(0)?.score==null){
                        holder.run1.text=null
                        holder.run2.text=null
                        holder.over1.text=null
                        holder.overs2.text=null
                    }else {
                        if (runteam1 == team1.id) {
                            holder.run1.text =
                                "${item.runs?.get(0)?.score.toString()}/${item.runs?.get(0)?.wickets.toString()}"
                            holder.run2.text =
                                "${item.runs?.get(1)?.score.toString()}/${item.runs?.get(1)?.wickets.toString()}"
                            holder.over1.text = "${item.runs?.get(0)?.overs.toString()}"
                            holder.overs2.text = "${item.runs?.get(1)?.overs.toString()}"
                        } else {
                            holder.run1.text =
                                "${item.runs?.get(1)?.score.toString()}/${item.runs?.get(1)?.wickets.toString()}"
                            holder.run2.text =
                                "${item.runs?.get(0)?.score.toString()}/${item.runs?.get(0)?.wickets.toString()}"
                            holder.over1.text = "${item.runs?.get(1)?.overs.toString()}"
                            holder.overs2.text = "${item.runs?.get(0)?.overs.toString()}"
                        }
                    }

                    holder.date.text="Date: ${item.starting_at!!.split("T")[0]}"
                    holder.time.text="Time: ${item.starting_at!!.split("T")[1].split(".")[0]}"
                    holder.itemView.setOnClickListener {
                        val action=HomeFragmentDirections.actionHomeFragmentToMatchFragment(item.stage?.name.toString(),item.venue?.name.toString(),item.manofmatch?.fullname.toString(),item.tosswon?.name.toString(),item.venue?.city.toString(),item.league?.name,item.league?.image_path,item.batting?.toTypedArray(),item.lineup?.toTypedArray())
                        Log.d("previnfo", "${item.stage?.name},${item.id}")
                        findNavController(holder.itemView).navigate(action)
                    }

                }



            }
        }
    }


    override fun getItemCount(): Int {
        return fixtures.size
    }
}