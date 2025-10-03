package com.miraitag.myapplication.data.api.model

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Comic>,
    val returned: Int
)