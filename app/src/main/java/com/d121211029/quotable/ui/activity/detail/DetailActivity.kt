package com.d121211029.quotable.ui.activity.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.d121211029.quotable.data.model.quote.Quote
import com.d121211029.quotable.ui.theme.QuotableTheme

class DetailActivity : ComponentActivity() {

    private var selectedQuote: Quote? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedQuote = intent.getParcelableExtra("QUOTES")
        setContent {
            QuotableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen(modifier = Modifier)
                }
            }
        }
    }

    @Composable
    private fun DetailScreen(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .background(Color.White)

        ){
            Column {
                Column {
                    Text(
                        text = selectedQuote?.content.toString(),
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold,
                        )

                    )
                    Text(
                        text = selectedQuote?.author.toString(),
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyMedium.copy(
                        )

                    )
                    Column(modifier = Modifier.padding(16.dp),) {
                        Row(
                            modifier = modifier
                        ){
                            selectedQuote?.tags?.let { tags ->
                                if (tags.isNotEmpty()) {
                                    tags.map { it -> Text(text = "Tags: ${it}") }
                                } else {
                                    Text(text = "Tags: No Tags")
                                }
                            }
                        }
                        Text(text = "Date Added: ${selectedQuote?.dateAdded}")

                        Text(text = "Author: ${selectedQuote?.author}")
                    }
                }
            }
        }
    }
}
