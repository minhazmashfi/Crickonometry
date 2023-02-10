package com.minhaz_uddin.crickonometry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minhaz_uddin.crickonometry.adapter.IntlTeamAdapter
import com.minhaz_uddin.crickonometry.viewModel.CrickViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val crickViewModel=ViewModelProvider(this)[CrickViewModel::class.java]
        val recyclerView=findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager=LinearLayoutManager(this)
        crickViewModel.readAllTeams.observe(this){
            recyclerView.adapter=IntlTeamAdapter(this, it)
            Log.d("adap", "$it.data ")
        }


    }
}