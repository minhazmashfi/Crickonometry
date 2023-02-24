package com.minhaz_uddin.crickonometry.model.info

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(
    val code: String?,
    val country_id: Int?,
    val id: Int?,
    val image_path: String?,
    val name: String?,
    val resource: String?,
    val season_id: Int?,
    val type: String?,
    val updated_at: String?
):Parcelable