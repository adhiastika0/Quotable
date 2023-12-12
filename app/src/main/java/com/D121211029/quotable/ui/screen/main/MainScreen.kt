package com.D121211029.quotable.ui.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.D121211029.quotable.R
import com.D121211029.quotable.data.Datasource
import com.D121211029.quotable.data.model.affirmation.Affirmation
import com.D121211029.quotable.ui.theme.QuotableTheme

@Composable
fun MainScreen(){
    Text("Test")
}

@Composable
fun QuoteCard(affirmation: Affirmation, modifier: Modifier = Modifier){
    Card(modifier = modifier) {
        Column {
            Text(
                text = LocalContext.current.getString(affirmation.quoteResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = LocalContext.current.getString(affirmation.authorResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
}

@Composable
fun QuoteList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier){
        items(affirmationList) { affirmation ->
            QuoteCard(
                affirmation = affirmation,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun QuoteApp(){
    QuoteList(affirmationList = Datasource().loadAffirmations(),)
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    QuotableTheme {
        QuoteApp()
    }
}