package com.miraitag.myapplication.data.api.model

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<Comic>,
    val returned: Int
)