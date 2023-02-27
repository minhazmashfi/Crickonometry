package com.minhaz_uddin.crickonometry.network

import com.minhaz_uddin.crickonometry.fixtureDetails.fixtureDetails
import com.minhaz_uddin.crickonometry.model.info.FixtureInformation
import com.minhaz_uddin.crickonometry.model.Constants
import com.minhaz_uddin.crickonometry.model.fixture.Fixtures
import com.minhaz_uddin.crickonometry.model.ranking.Ranking
import com.minhaz_uddin.crickonometry.model.teams.Teams
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private val moshi=Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit=Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(
    Constants.BASE_URL).build()


interface SportsApi {
    @GET("${Constants.BASE_URL}teams?api_token=${Constants.API_KEY}&include=")
    suspend fun getAllTeams():Teams
    @GET("${Constants.BASE_URL}fixtures?${Constants.recent_filter}&api_token=${Constants.API_KEY}&include=runs,stage,venue,manofseries,manofmatch,tosswon,league,batting,bowling,batting.batsman,lineup")
    suspend fun getAllFixtures(): FixtureInformation
    @GET ( "${Constants.BASE_URL}fixtures?${Constants.upcoming_filter}&api_token=${Constants.API_KEY}&include=stage,venue,manofseries,manofmatch,tosswon,league")
    suspend fun getAllUpcomings(): FixtureInformation
    @GET("${Constants.BASE_URL}team-rankings?filter[type]=ODI&api_token=${Constants.API_KEY}&include=")
    suspend fun getAllRankings():Ranking
    @GET("${Constants.BASE_URL}fixtures?filter[starts_between]=2023-01-15,2023-03-15&include=visitorteam,localteam,lineup&api_token=${Constants.API_KEY}")
    suspend fun getFixtureDl():fixtureDetails

}
object CricketApi{
    val retrofitService:SportsApi by lazy{ retrofit.create(SportsApi::class.java) }
}