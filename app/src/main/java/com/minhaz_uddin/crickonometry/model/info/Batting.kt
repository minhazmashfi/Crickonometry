package com.minhaz_uddin.crickonometry.model.info

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Batting(
    val active: Boolean?,
    val ball: Int?,
    val batsman: @RawValue Batsman?,
    val batsmanout_id:@RawValue Any?,
    val bowling_player_id: Int?,
    val catch_stump_player_id: Int?,
    val fixture_id: Int?,
    val four_x: Int?,
    val fow_balls: Double?,
    val fow_score: Int?,
    val id: Int?,
    val player_id: Int?,
    val rate: Int?,
    val resource: String?,
    val runout_by_id: Int?,
    val score: Int?,
    val score_id: Int?,
    val scoreboard: String?,
    val six_x: Int?,
    val sort: Int?,
    val team_id: Int?,
    val updated_at: String?
):Parcelable