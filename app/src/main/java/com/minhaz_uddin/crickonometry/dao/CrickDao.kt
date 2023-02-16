package com.minhaz_uddin.crickonometry.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.minhaz_uddin.crickonometry.model.fixture.FixtureData
import com.minhaz_uddin.crickonometry.model.teams.TeamData

@Dao
interface CrickDao {
    @Insert(onConflict =OnConflictStrategy.IGNORE)
    suspend fun addTeam(teamData: TeamData)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFixture(fixtureData: FixtureData)
    @Query("SELECT * FROM teamTable")
    fun readAllTeams():LiveData<List<TeamData>>
    @Query ("SELECT * FROM fixtureTable WHERE status=:status ")
    fun readAllRecentMatches(status: String):LiveData<List<FixtureData>>
    @Query("Select * From teamTable WHERE id=:id")
    fun getTeamInfo(id:Int):TeamData
    @Query("SELECT * FROM fixtureTable WHERE starting_at>=:date")
    fun readAllUpcoming(date:String):LiveData<List<FixtureData>>




}