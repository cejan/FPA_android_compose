package com.example.samplejetpack

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplejetpack.network.Repository
import com.example.samplejetpack.network.models.NetWorkQuotes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.Response
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: Repository
):  ViewModel(){
 /*   private val _creditCards = MutableLiveData<CreditCardResponse>()
    val creditCards: LiveData<CreditCardResponse> = _creditCards*/
    private val _Cards = MutableLiveData<String>()
    val cards: LiveData<String> = _Cards

    private val _CardsList = MutableLiveData<List<NetWorkQuotes>>()
    val cardsList: LiveData<List<NetWorkQuotes>> = _CardsList

    /*suspend fun getQuotesOfTheDay(): Response {
        return repository.getQuotesOfTheDay()
    }*/

    init{
        fetchCardList()
    }

    fun fetchCardList() {
        viewModelScope.launch {
            try {
                val cards1 = repository.getQuotesList()
                _CardsList.value = cards1
                //Log.e("FetchCreditCard", _creditCards.value.toString());
            } catch (e: Exception) {
                // Handle error
                Log.e("FetchCreditCard", e.message.toString());
            }
        }
    }

    fun fetchCards() {
        viewModelScope.launch {
            try {
                val cards1 = repository.getQuotesOfTheDay()?.h.toString()
                _Cards.value = cards1
                //Log.e("FetchCreditCard", _creditCards.value.toString());
            } catch (e: Exception) {
                // Handle error
                Log.e("FetchCreditCard", e.message.toString());
            }
        }
    }

   /* fun findbyID(id: Int): LiveData<String> {
        val result = MutableLiveData<String>()
        viewModelScope.launch {
            //JSONObject(response.body.toString())
            val respo = repository.getQuotesOfTheDay()?.h.toString()
            Log.e("Response", "asd1 ${respo} " )
            result.postValue(respo)
            //return repo
            //Log.e("Response", "asd ${respo} " )
        }
        Log.e("Response", "asd ${result} " )
        return result
    }*/

    fun fetchData() = viewModelScope.launch {
        //JSONObject(response.body.toString())
        val respo = repository.getQuotesOfTheDay()?.h
        //return repo
        Log.e("Response", "asd ${respo} " )
    }
}