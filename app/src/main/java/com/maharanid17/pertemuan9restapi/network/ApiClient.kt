package com.maharanid17.pertemuan9restapi.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val BASE_URL= "https://apitani.burunghantu.id/"

    val instance : ApiService by lazy{
        val retrofit =Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        retrofit.create(ApiService::class.java)
    }
}