package com.example.hstone.detail

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.hstone.favRoomDatabase.FavCard
import com.example.hstone.favRoomDatabase.FavCardDao
import com.example.hstone.network.CardProperty
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync

class DetailViewModel(cardProperty: CardProperty, val database: FavCardDao, app: Application):AndroidViewModel(app) {

    private val _selectedCard=MutableLiveData<CardProperty>()
    val selectedCard: LiveData<CardProperty>
        get() = _selectedCard


    init {
        _selectedCard.value=cardProperty
    }

    fun addCard(){
        doAsync {
            database.insertCard(FavCard(name= selectedCard.value?.name.toString()
                ,cardSet = selectedCard.value?.cardSet,
                type = selectedCard.value?.type,
                text = selectedCard.value?.text,
                img = selectedCard.value?.imgSrcUrl.toString(),
                local = selectedCard.value?.local))
        }
    }



}