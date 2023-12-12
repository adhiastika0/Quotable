package com.D121211029.quotable.data.response

import com.D121211029.quotable.data.model.quote.Quote

data class GetQuotesResponse(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Quote>,
    val totalCount: Int,
    val totalPages: Int
)