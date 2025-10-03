package com.miraitag.myapplication.data.api.retrofit

import com.miraitag.myapplication.data.api.model.Character
import com.miraitag.myapplication.data.api.model.MarvelResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): MarvelResponse<Character>
}