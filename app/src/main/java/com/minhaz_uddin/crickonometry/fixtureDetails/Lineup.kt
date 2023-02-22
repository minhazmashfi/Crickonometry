package com.minhaz_uddin.crickonometry.fixtureDetails

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "player_details")
data class Lineup(
    var battingstyle: String?,
    var bowlingstyle: String?,
    var country_id: Int,
    var dateofbirth: String?,
    var firstname: String,
    var fullname: String,
    var gender: String,
    @PrimaryKey
    var id: Int,
    var image_path: String,
    var lastname: String,
    @Ignore
    var lineup: LineupX?,
    @Ignore
    var position: Position?,
    var resource: String?,
    var updated_at: String?
){
    constructor():this("null","null",0,"null","null","null","null",
    0,"null","null",null,null,"null","null")
}