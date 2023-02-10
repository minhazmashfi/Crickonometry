package com.minhaz_uddin.crickonometry.network

import com.minhaz_uddin.crickonometry.model.Constants
import com.minhaz_uddin.crickonometry.model.fixture.FixtureData
import com.minhaz_uddin.crickonometry.model.fixture.Fixtures
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
    @GET("https://cricket.sportmonks.com/api/v2.0/teams?filter[country_id]=190324&api_token=KNq74r9kcedTzzf4XUIPppyaOkdvH48FcNEo1oeBGGI9wtMWcAQ470SMTgrH&include=")
    suspend fun getAllTeams():Teams
    @GET("https://cricket.sportmonks.com/api/v2.0/fixtures?api_token=KNq74r9kcedTzzf4XUIPppyaOkdvH48FcNEo1oeBGGI9wtMWcAQ470SMTgrH&include=runs&wickets")
    suspend fun getAllFixtures():Fixtures
}
object CricketApi{
    val retrofitService:SportsApi by lazy{ retrofit.create(SportsApi::class.java) }
}