package com.minhaz_uddin.crickonometry.model.teams

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teamTable")
data class TeamData(
    val code: String,
    val country_id: Int,
    @PrimaryKey
    val id: Int,
    val image_path: String,
    val name: String,
    val national_team: Boolean,
    val resource: String,
    val updated_at: String
)