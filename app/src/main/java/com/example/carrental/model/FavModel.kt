package com.example.carrental.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "fav_table")
class FavModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo
    var title: String = "",

    @ColumnInfo
    var description: String = ""
) : Serializable