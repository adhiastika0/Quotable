package com.D121211029.quotable.ui.activity.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.D121211029.quotable.R
import com.D121211029.quotable.data.Datasource
import com.D121211029.quotable.data.model.affirmation.Affirmation
import com.D121211029.quotable.ui.theme.QuotableTheme

@Composable
fun HomeHeader(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
        ),

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.app_name),
                textAlign = TextAlign.Center,
                color = Color.White, // Warna teks menjadi putih
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold

                )
            )
        }
    }
}
@Composable
fun QuoteCard(affirmation: Affirmation, modifier: Modifier = Modifier){
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp, horizontal = 16.dp),
        colors = CardDefaults.cardColors(
        containerColor = Color.White,
    ),
    ) {
        Column {
            Text(
                text = LocalContext.current.getString(affirmation.quoteResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                )
            )
            Text(
                text = LocalContext.current.getString(affirmation.authorResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontStyle = FontStyle.Italic
                )
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
            )
        }
    }
}

@Composable
fun MainScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(0.5f), // Setengah dari tinggi layar
        horizontalAlignment = Alignment.CenterHorizontally // Menyusun secara horizontal di tengah
    ) {
        HomeHeader()
        QuoteList(affirmationList = Datasource().loadAffirmations())
    }
}
@Preview(showBackground = true, backgroundColor = 0xE6E4E4)
@Composable
fun MainScreenPreview(){
    QuotableTheme {
        MainScreen()
    }
}