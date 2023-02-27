package com.minhaz_uddin.crickonometry.viewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.minhaz_uddin.crickonometry.dao.CrickDao
import com.minhaz_uddin.crickonometry.database.CrickDatabase
import com.minhaz_uddin.crickonometry.fixtureDetails.Lineup
import com.minhaz_uddin.crickonometry.fixtureDetails.fixtureDetails
import com.minhaz_uddin.crickonometry.model.info.FixtureInformation
import com.minhaz_uddin.crickonometry.model.fixture.FixtureData
import com.minhaz_uddin.crickonometry.model.ranking.RankingData
import com.minhaz_uddin.crickonometry.model.teams.TeamData
import com.minhaz_uddin.crickonometry.model.teams.Teams
import com.minhaz_uddin.crickonometry.network.CricketApi
import com.minhaz_uddin.crickonometry.repository.Repository
import com.minhaz_uddin.crickonometry.utils.MyApplication
import kotlinx.coroutines.launch

class CrickViewModel(application: Application):AndroidViewModel(application) {
    private var _teamList= MutableLiveData<Teams>()
    private var _fixtureList=MutableLiveData<FixtureInformation>()
    private var _upcomingList=MutableLiveData<FixtureInformation>()
    private var _rankingList= MutableLiveData<List<RankingData>>()
    private var _fixtureDlList=MutableLiveData<fixtureDetails>()
    var fixtureDlList=_fixtureDlList
    var upcomingList=_upcomingList
    var fixtureList=_fixtureList
    var teamList=_teamList
    var rankingList=_rankingList
    val readAllTeams:LiveData<List<TeamData>>
    val readRecentMatches:LiveData<List<FixtureData>>
    val readAllPlayers:LiveData<List<Lineup>>
    private val repository:Repository
    init{
        val crickDao:CrickDao=CrickDatabase.getDataBaseInstance(application).CrickDao()
        repository=Repository(crickDao)
        readAllTeams=repository.readAllTeams()
        readRecentMatches=repository.readAllRecentMatches("Finished")
        getAllTeams()
        getAllFixtures()
        getRanking()
        getFixtureDetails()
        readAllPlayers=repository.readAllPlayers()
    }
    fun getAllTeams(){
        viewModelScope.launch {
           try {
               _teamList.value = CricketApi.retrofitService.getAllTeams()
               Log.d("TAG", "${teamList.value}")
               for (team in _teamList.value!!.data) {
                   addTeam(team)

               }
           }catch (e:java.lang.Exception){

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
        try {
            _fixtureList.value = CricketApi.retrofitService.getAllFixtures()
            _upcomingList.value = CricketApi.retrofitService.getAllUpcomings()
        }catch (e:java.lang.Exception){
            Log.d("exception", "2$e ")

        }
    }

    }
    fun getTeamInfo(id:Int):TeamData{
        val teamdata=repository.getTeamInfo(id)
        Log.d("teamdata", "getTeamInfo: $teamdata")
        return repository.getTeamInfo(id)

    }

    fun getRanking() {
        viewModelScope.launch {
            try {
                _rankingList.value = CricketApi.retrofitService.getAllRankings().data
                Log.d("ranking", "getRanking:${rankingList.value} ")
            }catch (e:java.lang.Exception){
                Log.d("exception", " 1 $e ")
                Toast.makeText(MyApplication.instance,"Please check your Internet Connection1",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun getFixtureDetails(){
        viewModelScope.launch{
            try {
                _fixtureDlList.value = CricketApi.retrofitService.getFixtureDl()
            }catch (e:java.lang.Exception){

            }
            try {
                for (data in _fixtureDlList.value!!.data) {
                    val match = data
                    for (linup in match.lineup) {
                        repository.addPlayer(linup)
                    }
                }
            }catch (e:java.lang.Exception){

            }
        }
    }






}