package com.D121211029.quotable.data

import com.D121211029.quotable.R
import com.D121211029.quotable.data.model.affirmation.Affirmation


class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.quote1, R.string.author1),
            Affirmation(R.string.quote2, R.string.author2),
            Affirmation(R.string.quote3, R.string.author3))
    }
}