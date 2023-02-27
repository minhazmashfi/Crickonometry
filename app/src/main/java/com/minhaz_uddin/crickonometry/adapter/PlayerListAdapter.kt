package com.minhaz_uddin.crickonometry.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.minhaz_uddin.crickonometry.R
import com.minhaz_uddin.crickonometry.fixtureDetails.Lineup
import com.minhaz_uddin.crickonometry.fragments.PlayersFragment
import com.minhaz_uddin.crickonometry.fragments.PlayersFragmentDirections
import com.minhaz_uddin.crickonometry.fragments.PopupCard
import com.minhaz_uddin.crickonometry.utils.MyApplication
import java.util.zip.Inflater

class PlayerListAdapter(private val context:Context,private val squadPlayers:List<Lineup>,val fragmentManager:FragmentManager):RecyclerView.Adapter<PlayerListAdapter.PlayerViewHolder>() {
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
        holder.itemView.setOnClickListener{
            val popup=PopupCard(item.fullname,item.dateofbirth.toString(),item.battingstyle!!,item.bowlingstyle!!,item.image_path)

            popup.show(fragmentManager,"Popup")

        }

    }

    override fun getItemCount(): Int {
        return squadPlayers.size
    }
}