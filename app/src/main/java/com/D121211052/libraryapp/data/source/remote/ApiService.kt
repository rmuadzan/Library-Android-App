package com.D121211052.libraryapp.data.source.remote

import com.D121211052.libraryapp.data.response.GetBooksResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("volumes")
    suspend fun getBooks (
        @Query("printType") printType: String = "books",
        @Query("q") q: String = "a",
        @Query("projection") projection: String = "lite",
        @Query("maxResults") maxREsults: Int = 20,
        @Query("key") key: String = "AIzaSyArOtOpSfL9p0trT87LUlpoc7dGci3Vjd4",
    ): GetBooksResponse
}