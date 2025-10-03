package com.miraitag.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.miraitag.myapplication.ui.screens.characters.CharactersScreen
import com.miraitag.myapplication.ui.theme.MarvelComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MarvelApp {
                CharactersScreen {
                    // Handle character click
                }
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