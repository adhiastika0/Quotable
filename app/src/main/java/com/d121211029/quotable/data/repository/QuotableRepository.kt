package com.d121211029.quotable.data.repository

import com.d121211029.quotable.data.response.GetQuotesResponse
import com.d121211029.quotable.data.source.remote.ApiService

class QuotableRepository(private val apiService: ApiService) {

    suspend fun getQuotes(): GetQuotesResponse {
        return apiService.getQuotes()
    }

}