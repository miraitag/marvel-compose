package com.miraitag.myapplication.data.api.model

data class Data<T>(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<T>,
    val total: Int
)