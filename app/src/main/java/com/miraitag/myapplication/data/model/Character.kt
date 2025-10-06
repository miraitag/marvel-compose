package com.miraitag.myapplication.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val id: Int,
    val name : String,
    val descriptions: String,
    val thumbnail: String
)
