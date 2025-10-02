package com.miraitag.myapplication.data.network.model

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Comic>,
    val returned: Int
)