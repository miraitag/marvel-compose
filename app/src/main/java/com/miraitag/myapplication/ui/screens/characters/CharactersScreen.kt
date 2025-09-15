package com.example.marvelcompose.ui.screens.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marvelcompose.data.model.Character

@Composable
fun CharactersScreen(characters: List<Character>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp)
    ) {
        items(items = characters) {
            CharacterItem(it)
        }
    }
}

@Composable
fun CharacterItem(character: Character) {
    Column(modifier = Modifier) {
        Card {
            Image(
                painter = painter,
                contentDescription = contentDescription,
            )
        }
    }
}

@Preview
@Composable
private fun CharactersScreenPreview() {
    val characters = (1..10).map {
        Character(
            id = it,
            name = "Name $it",
            descriptions = "Description",
            thumbnail = "https://placehold.co/150x255/000000/FFF?text=name$it"
        )
    }
    CharactersScreen(characters = characters)
}