package com.minhaz_uddin.crickonometry.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.minhaz_uddin.crickonometry.R
import com.minhaz_uddin.crickonometry.model.info.Batting

class ScoreCardAdapter(private val context: Context,val batting_score:List<Batting>):RecyclerView.Adapter<ScoreCardAdapter.ScoreCardViewHolder>() {

    class ScoreCardViewHolder(private val view:View):RecyclerView.ViewHolder(view){
     val name=view.findViewById<TextView>(R.id.name)
     val balls=view.findViewById<TextView>(R.id.balls)
     val runs=view.findViewById<TextView>(R.id.runs)
     val strike_rate=view.findViewById<TextView>(R.id.strike_rate)
     val fours=view.findViewById<TextView>(R.id.four)
     val sixes=view.findViewById<TextView>(R.id.six)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreCardViewHolder {
        val adapterLayout=LayoutInflater.from(parent.context).inflate(R.layout.score_card,parent,false)
        return ScoreCardViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ScoreCardViewHolder, position: Int) {
      val item=batting_score[position]
        holder.name.text=item.batsman?.fullname.toString()
        holder.balls.text=item.ball.toString()
        holder.runs.text=item.score.toString()
        holder.strike_rate.text=item.rate.toString()
        holder.fours.text=item.four_x.toString()
        holder.sixes.text=item.six_x.toString()

    }

    override fun getItemCount(): Int {
        return batting_score.size
    }
}