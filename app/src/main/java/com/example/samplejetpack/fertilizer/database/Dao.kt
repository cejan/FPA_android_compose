package com.example.samplejetpack.fertilizer.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.samplejetpack.fertilizer.pojo.QuotesDB

@Dao
interface FertilizerDao {

    @Query("SELECT * FROM Quotes_table")
    fun getAllQuotes(): List<QuotesDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertQuotes(quotes: QuotesDB)

    @Delete
    fun deleteQuote(quotes: QuotesDB)
}