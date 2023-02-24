package com.minhaz_uddin.crickonometry.model.info

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class FixtureInfoData(
    val batting: List<Batting>?,
    val bowling: List<Bowling>?,
    val draw_noresult: String?,
    val elected: String?,
    val first_umpire_id: Int?,
    val follow_on: Boolean?,
    val id: Int?,
    val last_period: @RawValue Any?,
    val league: League?,
    val league_id: Int?,
    val lineup: List<Lineup>?,
    val live: Boolean?,
    val localteam_dl_data: LocalteamDlData?,
    val localteam_id: Int?,
    val man_of_match_id: Int?,
    val man_of_series_id: Int?,
    val manofmatch: Manofmatch?,
    val manofseries: Manofseries?,
    val note: String?,
    val referee_id: Int?,
    val resource: String?,
    val round: String?,
    val rpc_overs: String?,
    val rpc_target: String?,
    val runs: List<Run>?,
    val scoreboards: List<Scoreboard>?,
    val season_id: Int?,
    val second_umpire_id: Int?,
    val stage: Stage?,
    val stage_id: Int?,
    val starting_at: String?,
    val status: String?,
    val super_over: Boolean?,
    val toss_won_team_id: Int?,
    val tosswon: Tosswon?,
    val total_overs_played: Int?,
    val tv_umpire_id: Int?,
    val type: String?,
    val venue: Venue?,
    val venue_id: Int?,
    val visitorteam_dl_data: VisitorteamDlData?,
    val visitorteam_id: Int?,
    val weather_report:@RawValue List<Any>?,
    val winner_team_id: Int?
):Parcelable