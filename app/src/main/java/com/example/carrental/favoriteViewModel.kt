package com.example.carrental

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.carrental.db.FavDatabase
import com.example.carrental.db.repos.FavRealization
import com.example.carrental.db.repos.FavRepos
import com.example.carrental.model.FavModel

class favoriteViewModel(application: Application): AndroidViewModel(application) {

    val context = application


    fun initDatabase(){
        val daoFav = FavDatabase.getInstance(context).getFavDao()
        repos = FavRealization(daoFav)
    }
    fun getAllFaves(): LiveData<List<FavModel>>{
        return repos.allFaves
    }
}