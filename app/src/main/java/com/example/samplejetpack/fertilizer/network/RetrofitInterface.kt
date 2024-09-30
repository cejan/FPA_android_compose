package com.example.samplejetpack.fertilizer.network

import com.example.samplejetpack.fertilizer.pojo.QuotesDB
//import com.example.samplejetpack.network.models.NetWorkQuotes
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("quotes")
    suspend fun getQuotesList(): List<QuotesDB>

    @GET("quotes")
    fun getQuotesList2(): Call<List<QuotesDB>>

}