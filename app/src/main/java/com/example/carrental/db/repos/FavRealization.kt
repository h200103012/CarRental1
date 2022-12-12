package com.example.carrental.db.repos

import androidx.lifecycle.LiveData
import com.example.carrental.db.dao.FavDao
import com.example.carrental.model.FavModel

class FavRealization(private val favDao: FavDao): FavRepos {

    override val allFaves: LiveData<List<FavModel>>
    get() = favDao.getAllFaves()


    override suspend fun insertFav(favModel: FavModel, onSuccess: () -> Unit) {
        favDao.insert(favModel)
        onSuccess()
    }

    override suspend fun deleteFav(favModel: FavModel, onSuccess: () -> Unit) {
        favDao.delete(favModel)
        onSuccess()

    }
}