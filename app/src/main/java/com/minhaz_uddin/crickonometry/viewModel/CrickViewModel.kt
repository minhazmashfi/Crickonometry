package com.minhaz_uddin.crickonometry.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.minhaz_uddin.crickonometry.dao.CrickDao
import com.minhaz_uddin.crickonometry.database.CrickDatabase
import com.minhaz_uddin.crickonometry.model.fixture.FixtureData
import com.minhaz_uddin.crickonometry.model.fixture.Fixtures
import com.minhaz_uddin.crickonometry.model.teams.TeamData
import com.minhaz_uddin.crickonometry.model.teams.Teams
import com.minhaz_uddin.crickonometry.network.CricketApi
import com.minhaz_uddin.crickonometry.network.SportsApi
import com.minhaz_uddin.crickonometry.repository.Repository
import kotlinx.coroutines.launch

class CrickViewModel(application: Application):AndroidViewModel(application) {
    private var _teamList= MutableLiveData<Teams>()
    private var _fixtureList=MutableLiveData<Fixtures>()
    var fixtureList=_fixtureList
    var teamList=_teamList
    val readAllTeams:LiveData<List<TeamData>>
    private val repository:Repository
    init{
        val crickDao:CrickDao=CrickDatabase.getDataBaseInstance(application).CrickDao()
        repository=Repository(crickDao)
        readAllTeams=repository.readAllTeams()
        getAllTeams()
        getAllFixtures()
    }
    fun getAllTeams(){
        viewModelScope.launch {
            _teamList.value=CricketApi.retrofitService.getAllTeams()
            Log.d("TAG", "${teamList.value}")
            for (team in _teamList.value!!.data){
                addTeam(team)

            }

        }

    }
    suspend fun addTeam(teamData: TeamData){
        repository.addTeam(teamData)

    }
    suspend fun addFixture(fixtures: FixtureData){
        repository.addFixture(fixtures)
    }
    fun getAllFixtures(){
    viewModelScope.launch {
        _fixtureList.value = CricketApi.retrofitService.getAllFixtures()

        for (fixture in _fixtureList.value!!.data) {
            addFixture(fixture)
        }
    }
    }





}