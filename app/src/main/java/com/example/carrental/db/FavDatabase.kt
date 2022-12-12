package com.example.carrental.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.carrental.db.dao.FavDao
import com.example.carrental.model.FavModel


@Database(entities = [FavModel::class], version = 1)
abstract class FavDatabase: RoomDatabase() {
    abstract fun getFavDao(): FavDao

    companion object{
        private var database: FavDatabase ?= null


        @Synchronized
        fun getInstance(context: Context) : FavDatabase{
            return if (database == null){
                database = Room.databaseBuilder(context, FavDatabase::class.java, "db").build()
                database as FavDatabase
            }else{
                database as FavDatabase
            }
        }
    }
}