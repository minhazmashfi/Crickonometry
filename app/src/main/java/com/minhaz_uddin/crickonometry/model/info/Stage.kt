package com.minhaz_uddin.crickonometry.model.info

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stage(
    val code: String?,
    val id: Int?,
    val league_id: Int?,
    val name: String?,
    val resource: String?,
    val season_id: Int?,
    val standings: Boolean?,
    val type: String?,
    val updated_at: String?
):Parcelable