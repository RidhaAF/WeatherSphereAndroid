package com.ridhaaf.wheatersphereandroid.utils

import java.util.Properties

object AppConfig {
    private val properties = Properties()

    init {
        val inputStream = javaClass.classLoader?.getResourceAsStream("env.properties")
        properties.load(inputStream)
    }

    val baseUrl: String
        get() = properties.getProperty("BASE_URL", "")

    val apiKey: String
        get() = properties.getProperty("API_KEY", "")
}