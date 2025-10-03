package com.miraitag.myapplication.data.api.model

data class Thumbnail(
    val extension: String,
    val path: String
)

fun Thumbnail.asString() = "$path.$extension".replace("http", "https")