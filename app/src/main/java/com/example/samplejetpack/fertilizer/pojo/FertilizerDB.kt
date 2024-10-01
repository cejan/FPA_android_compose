package com.example.samplejetpack.fertilizer.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Quotes_table")
data class QuotesDB(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val quotesId: Int = 0,
    @ColumnInfo(name = "Quotes")
    val q: String?,
    @ColumnInfo(name = "Author")
    val a: String?,
    @ColumnInfo(name = "html")
    val h: String?
)

