package com.miraitag.myapplication.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object Characters

@Serializable
data class CharacterDetail(val id: String)