package com.D121211052.libraryapp.data.repository

import com.D121211052.libraryapp.data.response.GetBooksResponse
import com.D121211052.libraryapp.data.source.remote.ApiService

class BooksRepositories(private val apiService: ApiService) {
    suspend fun getBooks(): GetBooksResponse {
        return apiService.getBooks()
    }
}