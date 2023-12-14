package com.D121211052.libraryapp.data

import com.D121211052.libraryapp.data.repository.BooksRepositories
import com.D121211052.libraryapp.data.source.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val booksRepositories: BooksRepositories
}

class DefaultAppContainter: AppContainer {
    private val BASE_URL = "https://www.googleapis.com/books/v1/"

    private val jsonConfig = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(jsonConfig.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val booksRepositories: BooksRepositories
        get() = BooksRepositories(retrofitService)
}