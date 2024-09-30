package com.example.samplejetpack.fertilizer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplejetpack.fertilizer.database.FertilizerRepository
import com.example.samplejetpack.fertilizer.pojo.QuotesDB
import com.example.samplejetpack.network.models.NetWorkQuotes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//import javax.inject.Inject

@HiltViewModel
class FertilizerViewModel @Inject constructor(
    private val FertRepository: FertilizerRepository
):  ViewModel(){

    /*private val _CardsList = MutableLiveData<List<QuotesDB>>()
    val cardsList: LiveData<List<QuotesDB>> = _CardsList
*/
    init {
        makeApiCall()
    }

    fun makeApiCall() {
        viewModelScope.launch {
            try {
                val cards1 = FertRepository.makeApiCall("ny")
                //_CardsList.value = cards1.r
                Log.e("FetchCreditCard", cards1.toString())
                //Log.e("FetchCreditCard", _creditCards.value.toString());
            } catch (e: Exception) {
                // Handle error
                Log.e("FetchCreditCard", e.message.toString())
            }
        }

    }

}