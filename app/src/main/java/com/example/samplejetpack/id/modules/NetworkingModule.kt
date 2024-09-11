package com.example.samplejetpack.id.modules

import com.example.samplejetpack.network.Service
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkingModule {
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://zenquotes.io/api")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    @Provides
    fun provideQuoteService(retrofit: Retrofit): Service {
        return retrofit.create(Service::class.java)
    }
}