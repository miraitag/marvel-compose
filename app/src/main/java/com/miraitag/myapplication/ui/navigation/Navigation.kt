package com.miraitag.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.miraitag.myapplication.ui.screens.characters.CharactersScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Characters
    ) {
        composable<Characters> {
            CharactersScreen {
                navController.navigate(CharacterDetail(id = it.id.toString()))
            }
        }
        /*composable<CharacterDetail> {
            val (id) = it.toRoute<CharacterDetail>()
            CharacterDetailScreen(id = id)
        }*/
    }
}