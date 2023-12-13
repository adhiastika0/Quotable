package com.d121211029.quotable.data.source.remote

import com.d121211029.quotable.data.response.GetQuotesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("quotes?limit=1000")
    suspend fun getQuotes(
    ): GetQuotesResponse

}