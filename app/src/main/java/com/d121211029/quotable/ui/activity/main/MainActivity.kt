package com.d121211029.quotable.ui.activity.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.d121211029.quotable.data.model.quote.Quote
import com.d121211029.quotable.ui.activity.detail.DetailActivity
import com.d121211029.quotable.ui.theme.QuotableTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    titleContentColor = MaterialTheme.colorScheme.background
                                ),
                                title = { Text(text = "Quotable") },

                            )
                        },
                    ) {
                        Column(modifier = Modifier.padding(it)) {
                            val mainViewModel: MainViewModel =
                                viewModel(factory = MainViewModel.Factory)
                            ListQuotesScreen(mainViewModel.mainUiState)
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ListQuotesScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        when (mainUiState) {
            is MainUiState.Success -> ListQuotes(mainUiState.quotes)
            is MainUiState.Error -> ErrorText()
            is MainUiState.Loading -> LoadingBar()
        }
    }

    @Composable
    private fun ErrorText() {
        Text(text = "ERROR")
    }

    @Composable
    fun LoadingBar() {
        Text(text = "SEDANG LOADING")
    }

    @Composable
    private fun ListQuotes(quotes: List<Quote>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(quotes) { quotes ->
                QuotesCard(quotes = quotes)
            }
        }
    }

    @Composable
    private fun QuotesCard(quotes: Quote, modifier: Modifier = Modifier) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("QUOTES", quotes)
                startActivity(intent)
            },
            colors = CardDefaults.cardColors(
                containerColor = Color.White)
        ) {
            Column {
                Text(
                    text = quotes.content ?: "Loading Content",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = quotes.author ?: "Loading Author",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontStyle = FontStyle.Italic
                    )
                )
            }
        }
    }
}

