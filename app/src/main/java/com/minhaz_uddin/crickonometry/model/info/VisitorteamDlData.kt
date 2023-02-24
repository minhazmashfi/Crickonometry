package com.minhaz_uddin.crickonometry.model.info

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VisitorteamDlData(
    val overs: String?,
    val score: String?,
    val total_overs_played: String?,
    val wickets_out: String?
)
    :Parcelable