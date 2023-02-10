package com.minhaz_uddin.crickonometry

import androidx.room.TypeConverter
import com.minhaz_uddin.crickonometry.model.fixture.LocalteamDlData
import com.minhaz_uddin.crickonometry.model.fixture.VisitorteamDlData

class Converter {
    @TypeConverter
    fun fromLctdlToString(value:LocalteamDlData):String{
        return value.overs.toString()

    }
    @TypeConverter
    fun FromStringtoLctdl(value:String):LocalteamDlData{
        return LocalteamDlData(value,"0","0","0","0")
    }

}