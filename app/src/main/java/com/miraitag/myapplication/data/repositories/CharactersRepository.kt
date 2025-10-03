package com.miraitag.myapplication.data.repositories

import com.miraitag.myapplication.data.api.model.asString
import com.miraitag.myapplication.data.api.retrofit.MarvelApiClient
import com.miraitag.myapplication.data.model.Character

object CharactersRepository {

    suspend fun getCharacters(): List<Character> {
        val result = MarvelApiClient.api.getCharacters(offset = 0, limit = 100)
        return result.data.results.map {
            Character(
                id = it.id,
                name = it.name,
                descriptions = it.description,
                thumbnail = it.thumbnail.asString()
            )
        }
    }
}