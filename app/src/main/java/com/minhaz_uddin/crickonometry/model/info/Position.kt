package com.minhaz_uddin.crickonometry.model.info

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Position(
    val id: Int?,
    val name: String?,
    val resource: String?
):Parcelable