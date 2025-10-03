package com.miraitag.myapplication.ui.screens.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.miraitag.myapplication.MarvelApp
import com.miraitag.myapplication.R
import com.miraitag.myapplication.data.model.Character
import com.miraitag.myapplication.data.repositories.CharactersRepository

@Composable
fun CharactersScreen(onCharacterClick: (Character) -> Unit) {

    var charactersState by rememberSaveable { mutableStateOf(emptyList<Character>()) }

    LaunchedEffect(Unit) {
        charactersState = CharactersRepository.getCharacters()
    }

    CharacterScreen(
        characters = charactersState,
        onCharacterClick = onCharacterClick,
    )
}


@Composable
fun CharacterScreen(characters: List<Character>, onCharacterClick: (Character) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(items = characters) {
            CharacterItem(
                character = it,
                modifier = Modifier.clickable { onCharacterClick(it) }
            )
        }
    }
}

@Composable
fun CharacterItem(character: Character, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Card {
            AsyncImage(
                model = character.thumbnail,
                contentDescription = character.name,
                placeholder = painterResource(R.drawable.marvel_placeholder),
                error = painterResource(R.drawable.marvel_error),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Text(
                text = character.name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 16.dp)
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterScreenPreview() {
    val characters = (1..10).map {
        Character(
            id = it,
            name = "Name $it",
            descriptions = "Description",
            thumbnail = "https://dummyimage.com/150x255/ff6600/ffffff&text=nombre$it"
        )
    }
    MarvelApp {
        CharacterScreen(
            characters = characters,
            onCharacterClick = {}
        )
    }
}