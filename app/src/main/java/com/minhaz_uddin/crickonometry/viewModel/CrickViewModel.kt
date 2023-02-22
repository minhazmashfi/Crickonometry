package com.minhaz_uddin.crickonometry.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.minhaz_uddin.crickonometry.dao.CrickDao
import com.minhaz_uddin.crickonometry.database.CrickDatabase
import com.minhaz_uddin.crickonometry.fixtureDetails.FixtureDl
import com.minhaz_uddin.crickonometry.fixtureDetails.Lineup
import com.minhaz_uddin.crickonometry.fixtureDetails.fixtureDetails
import com.minhaz_uddin.crickonometry.model.fixture.FixtureData
import com.minhaz_uddin.crickonometry.model.fixture.Fixtures
import com.minhaz_uddin.crickonometry.model.fixture.Run
import com.minhaz_uddin.crickonometry.model.ranking.Ranking
import com.minhaz_uddin.crickonometry.model.ranking.RankingData
import com.minhaz_uddin.crickonometry.model.teams.TeamData
import com.minhaz_uddin.crickonometry.model.teams.Teams
import com.minhaz_uddin.crickonometry.network.CricketApi
import com.minhaz_uddin.crickonometry.repository.Repository
import kotlinx.coroutines.launch

class CrickViewModel(application: Application):AndroidViewModel(application) {
    private var _teamList= MutableLiveData<Teams>()
    private var _fixtureList=MutableLiveData<Fixtures>()
    private var _upcomingList=MutableLiveData<Fixtures>()
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
        _upcomingList.value=CricketApi.retrofitService.getAllUpcomings()
        for (fixture in _fixtureList.value!!.data) {

            addFixture(fixture)
        }
        for (fixture in _upcomingList.value!!.data){
            addFixture(fixture)
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
            _rankingList.value = CricketApi.retrofitService.getAllRankings().data
            Log.d("ranking", "getRanking:${rankingList.value} ")
        }
    }
    fun getFixtureDetails(){
        viewModelScope.launch{
            _fixtureDlList.value=CricketApi.retrofitService.getFixtureDl()
            for (data in _fixtureDlList.value!!.data){
                val match=data
                for (linup in match.lineup){
                 repository.addPlayer(linup)
                }
            }


        }
    }






}