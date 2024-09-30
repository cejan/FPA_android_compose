package com.example.samplejetpack.fertilizer.database

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.samplejetpack.fertilizer.network.RetrofitInterface
import com.example.samplejetpack.fertilizer.pojo.QuotesDB
//import com.example.samplejetpack.network.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class FertilizerRepository @Inject constructor(
    private val retroServiceInterface: RetrofitInterface,
    private val fertilizerDao: FertilizerDao
)
{

    fun getAllRecords(): List<QuotesDB> {
        return fertilizerDao.getAllQuotes()
    }

    fun insertRecord(FertilizerData: QuotesDB) {
        fertilizerDao.insertQuotes(FertilizerData)
    }

    fun makeApiCall(query: String?) {
        val call: Call<List<QuotesDB>> = retroServiceInterface.getQuotesList2()
        call.enqueue(object : Callback<List<QuotesDB>> {
            override fun onResponse(
                call: Call<List<QuotesDB>>,
                response: Response<List<QuotesDB>>
            ) {
                Log.e("--------------",response.toString())
                if(response.isSuccessful) {
                    //appDao.deleteAllRecords()
                    response.body()?.forEach {
                        insertRecord(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<QuotesDB>>, t: Throwable) {
                Log.e("warning","sample",t)
            }
        })


    }


}