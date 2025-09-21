package com.miraitag.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.miraitag.myapplication.data.model.Character
import com.miraitag.myapplication.ui.screens.characters.CharactersScreen
import com.miraitag.myapplication.ui.theme.MarvelComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val characters = (1..10).map {
                Character(
                    id = it,
                    name = "Name $it",
                    descriptions = "Description",
                    thumbnail = "https://dummyimage.com/150x255/ff6600/ffffff&text=nombre$it"
                )
            }
            characters.forEach {
                Log.i("Marvel", "marvel ${it.thumbnail}", )
            }
            MarvelApp {
                CharactersScreen(characters = characters)
            }
        }
    }
}

@Composable
fun MarvelApp(content: @Composable () -> Unit) {
    MarvelComposeTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}