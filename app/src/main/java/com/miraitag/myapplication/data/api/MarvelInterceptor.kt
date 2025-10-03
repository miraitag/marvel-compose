package com.miraitag.myapplication.data.api

import okhttp3.Interceptor
import okhttp3.Response
import java.security.MessageDigest

class MarvelInterceptor(
    private val publicKey: String,
    private val privateKey: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val ts = System.currentTimeMillis().toString()
        val hash = generateHash(ts, privateKey, publicKey)

        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("ts", ts)
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("hash", hash)
            .build()

        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }

    private fun generateHash(ts: String, privateKey: String, publicKey: String): String {
        val input = ts + privateKey + publicKey
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(input.toByteArray())
        return digest.joinToString("") { "%02x".format(it) }
    }
}