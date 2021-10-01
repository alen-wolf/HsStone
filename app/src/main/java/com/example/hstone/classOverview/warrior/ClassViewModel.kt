package com.example.hstone.classOverview.warrior

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hstone.network.CardApiFilter
import com.example.hstone.network.CardProperty
import com.example.hstone.network.HstoneApi
import kotlinx.coroutines.launch
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import android.util.Log.v as v1

class ClassViewModel() : ViewModel() {

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response


    private val _properties = MutableLiveData<List<CardProperty>>()

    val properties: LiveData<List<CardProperty>>
        get() = _properties

    private val _navigateToSelectedCard = MutableLiveData<CardProperty>()
    val navigateToSelectedCard:LiveData<CardProperty>
        get()=_navigateToSelectedCard

    init {
        getClassCards(CardApiFilter.SHOW_ALL)
    }





    private fun getClassCards(filter: CardApiFilter){
        viewModelScope.launch {
            try{
                _properties.value = HstoneApi.retrofitService.getCard("Warrior",filter.value)
                _response.value="Sucess"
            }catch (e: Exception){
                _response.value="Failure ${e.message}"
            }

        }
    }

    fun updateFilter(filter: CardApiFilter){
        getClassCards(filter)
    }

    fun displayCardDetails(cardProperty: CardProperty){
        _navigateToSelectedCard.value=cardProperty
    }

    fun displayCardDetailsComplete(){
        _navigateToSelectedCard.value=null
    }

}