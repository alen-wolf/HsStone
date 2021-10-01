package com.example.hstone.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hstone.favRoomDatabase.FavCardDao
import com.example.hstone.network.CardProperty

class DetailViewModelFactory (
    private val card: CardProperty,
    private val datasourse: FavCardDao,
    private val application: Application) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
                return DetailViewModel(card,datasourse, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }

}