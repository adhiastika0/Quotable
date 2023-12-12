package com.D121211029.quotable.data.model.affirmation

import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val quoteResourceId: Int,
    @StringRes val authorResourceId: Int
)