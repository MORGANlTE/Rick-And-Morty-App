package com.rl.rickandmortyapp.network.episodes

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://rickandmortyapi.com/api/episode/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .build()

private val retrofit =
    Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .client(client)
        .build()

//interface for the different HTTP methods
interface EpisodeApiService{
    @GET(".")
    fun getEpisodes() : Deferred<EpisodeResponse>
}

//singleton to handle the instance of retrofit with the HTTP methods from the interface above
object EpisodeApi {
    val retrofitService : EpisodeApiService by lazy {
        retrofit.create(EpisodeApiService::class.java)
    }
}