package com.example.carrental.db.repos

import androidx.lifecycle.LiveData
import com.example.carrental.model.FavModel

interface FavRepos {

    val allFaves: LiveData<List<FavModel>>

    suspend fun insertFav(favModel: FavModel, onSuccess:() -> Unit)
    suspend fun deleteFav(favModel: FavModel, onSuccess:() -> Unit)
}