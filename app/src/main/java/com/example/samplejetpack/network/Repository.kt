package com.example.samplejetpack.network

import com.example.samplejetpack.network.models.NetWorkQuotes
import okhttp3.Response
import okhttp3.ResponseBody
import javax.inject.Inject

class Repository @Inject constructor(
    private val service1: Service
){
    suspend fun getQuotesOfTheDay(): NetWorkQuotes? {
        return service1.getQuotesOfTheDay().body()?.first()
    }

    suspend fun getQuotesList(): List<NetWorkQuotes> {
        return service1.getQuotesList()
    }

}