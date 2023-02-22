package com.minhaz_uddin.crickonometry.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.minhaz_uddin.crickonometry.dao.CrickDao
import com.minhaz_uddin.crickonometry.fixtureDetails.Lineup
import com.minhaz_uddin.crickonometry.model.fixture.FixtureData
import com.minhaz_uddin.crickonometry.model.teams.TeamData


@Database(entities=[TeamData::class,FixtureData::class,Lineup::class], version = 11, exportSchema = false)
abstract class CrickDatabase:RoomDatabase() {
    abstract fun CrickDao():CrickDao
    companion object{
        private var INSTANCE:CrickDatabase?=null
        fun getDataBaseInstance(context: Context):CrickDatabase{
            var instance= INSTANCE
            if (instance!=null){
                return instance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(context.applicationContext,CrickDatabase::class.java,"Fixture Database").fallbackToDestructiveMigration().build()
                INSTANCE=instance
                return instance
            }


        }
    }
}