package com.example.carrental.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.carrental.model.FavModel


@Dao
interface FavDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favModel: FavModel)

    @Delete
    suspend fun delete(noteModel: FavModel)

    @Query("Select * from fav_table")
    fun getAllFaves(): LiveData<List<FavModel>>
}