package com.example.hstone.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

enum class CardApiFilter(val value: Double){
    SHOW_COLLECTIBLE(1.0),
    SHOW_ALL(0.0)
}

private const val BASE_URL = "https://omgvamp-hearthstone-v1.p.rapidapi.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HstoneApiService {
    @Headers(
        "X-Rapidapi-Key: 73c4ab10aamsh9f5df67706759e1p18f62fjsncfcf6887d8e2",
        "X-Rapidapi-Host: omgvamp-hearthstone-v1.p.rapidapi.com)"
    )
    @GET("/cards/classes/{class}")
    suspend fun getCard(@Path("class", encoded = true) clas: String,
                        @Query("collectible") col:Double):List<CardProperty>

}

object HstoneApi{

    val retrofitService : HstoneApiService by lazy {
        retrofit.create(HstoneApiService::class.java)
    }


}