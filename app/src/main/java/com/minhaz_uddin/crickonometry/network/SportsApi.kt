package com.minhaz_uddin.crickonometry.network

import com.minhaz_uddin.crickonometry.fixtureDetails.FixtureDl
import com.minhaz_uddin.crickonometry.fixtureDetails.fixtureDetails
import com.minhaz_uddin.crickonometry.model.Constants
import com.minhaz_uddin.crickonometry.model.fixture.Fixtures
import com.minhaz_uddin.crickonometry.model.ranking.Ranking
import com.minhaz_uddin.crickonometry.model.ranking.RankingData
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
    @GET("https://cricket.sportmonks.com/api/v2.0/teams?api_token=KNq74r9kcedTzzf4XUIPppyaOkdvH48FcNEo1oeBGGI9wtMWcAQ470SMTgrH&include=")
    suspend fun getAllTeams():Teams
    @GET("https://cricket.sportmonks.com/api/v2.0/fixtures?filter[starts_between]=2023-1-15,2023-2-15&api_token=KNq74r9kcedTzzf4XUIPppyaOkdvH48FcNEo1oeBGGI9wtMWcAQ470SMTgrH&include=runs")
    suspend fun getAllFixtures():Fixtures
    @GET ( "https://cricket.sportmonks.com/api/v2.0/fixtures?filter[starts_between]=2023-2-28,2023-4-28&api_token=KNq74r9kcedTzzf4XUIPppyaOkdvH48FcNEo1oeBGGI9wtMWcAQ470SMTgrH&include=")
    suspend fun getAllUpcomings():Fixtures
    @GET("https://cricket.sportmonks.com/api/v2.0/team-rankings?filter[type]=ODI&api_token=KNq74r9kcedTzzf4XUIPppyaOkdvH48FcNEo1oeBGGI9wtMWcAQ470SMTgrH&include=")
    suspend fun getAllRankings():Ranking
    @GET("https://cricket.sportmonks.com/api/v2.0/fixtures?filter[starts_between]=2023-01-15,2023-03-15&include=visitorteam,localteam,lineup&api_token=KNq74r9kcedTzzf4XUIPppyaOkdvH48FcNEo1oeBGGI9wtMWcAQ470SMTgrH")
    suspend fun getFixtureDl():fixtureDetails

}
object CricketApi{
    val retrofitService:SportsApi by lazy{ retrofit.create(SportsApi::class.java) }
}