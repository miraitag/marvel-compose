package com.miraitag.myapplication.data.api.model

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Comic>,
    val returned: Int
)