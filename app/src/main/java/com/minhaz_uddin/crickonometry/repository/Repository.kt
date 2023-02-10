package com.minhaz_uddin.crickonometry.repository

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

}