package com.miraitag.myapplication.data.repositories

import com.miraitag.myapplication.data.api.model.asString
import com.miraitag.myapplication.data.api.retrofit.MarvelApiClient
import com.miraitag.myapplication.data.model.Character
import com.miraitag.myapplication.data.api.model.Character as ApiCharacter


object CharactersRepository {

    suspend fun getCharacters(): List<Character> {
        val result = MarvelApiClient.api.getCharacters(offset = 0, limit = 100)
        return result.data.results.map { it.toCharacter() }
    }

    suspend fun findCharacterById(characterId: Int): Character {
        val result = MarvelApiClient.api.findCharacterById(characterId = characterId)
        return result.data.results.first().toCharacter()
    }
}

fun ApiCharacter.toCharacter() = Character(
    id = id,
    name = name,
    descriptions = description,
    thumbnail = thumbnail.asString()
)
