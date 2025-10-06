package com.miraitag.myapplication.ui.screens.characterDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.miraitag.myapplication.data.model.Character
import com.miraitag.myapplication.data.repositories.CharactersRepository

@Composable
fun CharacterDetailScreen(characterId: Int) {
    var characterState by remember { mutableStateOf<Character?>(null) }

    LaunchedEffect(Unit) {
        characterState = CharactersRepository.findCharacterById(characterId = characterId)
    }

    characterState?.let {
        CharacterDetail(character = it)
    }
}

@Composable
fun CharacterDetail(character: Character) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = character.name)
    }
}