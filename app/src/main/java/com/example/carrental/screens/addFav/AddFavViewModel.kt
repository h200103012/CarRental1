package com.example.carrental.screens.addFav

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carrental.model.FavModel
import com.example.carrental.repos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddFavViewModel: ViewModel() {

    fun insert(favModel: FavModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO)  {
            repos.insertFav(favModel){
                onSuccess()
            }
        }
}