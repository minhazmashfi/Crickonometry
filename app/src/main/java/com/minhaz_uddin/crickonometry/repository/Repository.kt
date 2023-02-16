package com.minhaz_uddin.crickonometry.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.minhaz_uddin.crickonometry.dao.CrickDao
import com.minhaz_uddin.crickonometry.model.fixture.FixtureData
import com.minhaz_uddin.crickonometry.model.teams.TeamData

class Repository(private val crickDao:CrickDao) {
    fun readAllTeams():LiveData<List<TeamData>> =crickDao.readAllTeams()
    suspend fun addTeam(teamData: TeamData){
        crickDao.addTeam(teamData)

    }
    suspend fun addFixture(fixtureData: FixtureData){
        crickDao.addFixture(fixtureData)
    }
    fun readAllRecentMatches(status:String):LiveData<List<FixtureData>>{
        return crickDao.readAllRecentMatches(status)
    }
     fun getTeamInfo(id:Int):TeamData{
        return crickDao.getTeamInfo(id)
    }
    fun readAllUpcomings(date:String):LiveData<List<FixtureData>>{
        val repo=crickDao.readAllUpcoming(date)
        Log.d("repo", "readAllUpcomings:${repo.value} ")
        return crickDao.readAllUpcoming(date)
    }

}