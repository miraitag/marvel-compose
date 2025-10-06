package com.miraitag.myapplication.data.api.retrofit

import com.miraitag.myapplication.data.api.model.Character
import com.miraitag.myapplication.data.api.model.MarvelResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {
    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): MarvelResponse<Character>

    @GET("v1/public/characters/{characterId}")
    suspend fun findCharacterById(
        @Path("characterId") characterId: Int
    ): MarvelResponse<Character>
}