package com.example.samplejetpack.fertilizer.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.samplejetpack.fertilizer.pojo.QuotesDB

//import com.demo.paging3withroom.model.Fertilizer

@Database(entities = [QuotesDB::class], version = 1, exportSchema = false)
abstract class FertDatabase: RoomDatabase() {

    abstract fun getAppDao(): FertilizerDao

    companion object {
        private var DB_INSTANCE: FertDatabase? = null

        fun getAppDBInstance(context: Context): FertDatabase {
            if(DB_INSTANCE == null) {
                DB_INSTANCE =  Room.databaseBuilder(context.applicationContext, FertDatabase::class.java, "FERT_APP_DB1")
                    .allowMainThreadQueries()
                    .build()
            }
            return DB_INSTANCE!!
        }
    }
}