package com.example.samplejetpack.id.modules

import android.app.Application
import android.content.Context
import com.example.samplejetpack.fertilizer.database.FertDatabase
import com.example.samplejetpack.fertilizer.database.FertilizerDao
import com.example.samplejetpack.fertilizer.network.RetrofitInterface
import com.example.samplejetpack.network.Service

import com.squareup.moshi.Moshi

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

//import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkingModule {
   /* private val moshi = Moshi.Builder()
        //.add(KotlinJsonAdapterFactory())
        .build()*/
    //@Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://zenquotes.io/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    //@Singleton
    @Provides
    fun provideQuoteService(retrofit: Retrofit): Service {
        return retrofit.create(Service::class.java)
    }

    @Provides
    fun provideRetrofitInterface(retrofit: Retrofit): RetrofitInterface {
        return retrofit.create(RetrofitInterface::class.java)
    }


    /*@Provides
    fun provideAppContext(): FertDatabase {
        return Context
    }*/

    @Provides
    @Singleton
    fun provideAppDatabase(context: Application): FertDatabase {
        return FertDatabase.getAppDBInstance(context)
    }

    @Provides
    @Singleton
    fun provideFertilizerDao(appDatabase: FertDatabase): FertilizerDao {
        return appDatabase.getAppDao()
    }

    /*@Provides
    fun providesAPI(): Service{
        return Retrofit.Builder()
            .baseUrl("https://zenquotes.io/api")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(Service::class.java)
    }*/
}