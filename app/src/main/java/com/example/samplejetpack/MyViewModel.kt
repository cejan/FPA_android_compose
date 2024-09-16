package com.example.samplejetpack

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplejetpack.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.Response
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: Repository
):  ViewModel(){

    /*suspend fun getQuotesOfTheDay(): Response {
        return repository.getQuotesOfTheDay()
    }*/
    fun fetchData() = viewModelScope.launch {
        //JSONObject(response.body.toString())
        val respo = repository.getQuotesOfTheDay().toString()
        //return repo
        Log.e("Response", "asd ${respo} " )
    }
}