package com.minhaz_uddin.crickonometry.model.info

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LineupX(
    val captain: Boolean?,
    val substitution: Boolean?,
    val team_id: Int?,
    val wicketkeeper: Boolean?
):Parcelable