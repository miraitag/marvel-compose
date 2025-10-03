package com.miraitag.myapplication.data.api.retrofit

import com.miraitag.myapplication.BuildConfig
import com.miraitag.myapplication.data.api.MarvelInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelApiClient {

    private const val BASE_URL = "https://gateway.marvel.com/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            MarvelInterceptor(
                publicKey = BuildConfig.MARVEL_PUBLIC_KEY,
                privateKey = BuildConfig.MARVEL_PRIVATE_KEY
            )
        ).build()

    val api: MarvelApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarvelApi::class.java)
    }
}