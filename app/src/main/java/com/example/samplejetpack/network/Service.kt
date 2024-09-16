package com.example.samplejetpack.network

import com.example.samplejetpack.network.models.NetWorkQuotes
//import okhttp3.Response
//import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface Service {
    @GET("today")
    suspend fun getQuotesOfTheDay(): Response<List<NetWorkQuotes>>
    //suspend fun getQoutesOfThe

}