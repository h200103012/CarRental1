package com.example.carrental.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carrental.model.FavModel
import com.example.carrental.repos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    fun delete(favModel: FavModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO)  {
            repos.deleteFav(favModel){
                onSuccess()
            }
        }
}

