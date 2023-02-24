package com.minhaz_uddin.crickonometry.model.info

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocalteamDlData(
    val overs: String?,
    val rpc_overs: String?,
    val rpc_targets: String?,
    val score: String?,
    val wickets_out: String?
):Parcelable