package com.d121211029.quotable.ui.activity.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.d121211029.quotable.R
import com.d121211029.quotable.ui.theme.QuotableTheme


@Composable
fun DetailHeader(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .background(Color.White)
            .fillMaxWidth()
        ){
        Text(
            text = stringResource(R.string.detail),
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )

        )
    }
}

@Composable
fun DetailContent(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .background(Color.White)
            .fillMaxWidth()
    ){
        Column {
            Column {
                Text(
                    text = stringResource(R.string.quote1),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                    )

                )
                Text(
                    text = stringResource(R.string.author1),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium.copy(
                    )

                )
            }
            Column {
                Text(
                    text = stringResource(R.string.quote1),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                    )

                )
                Text(
                    text = stringResource(R.string.author1),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium.copy(
                    )

                )
                Column(modifier = Modifier.padding(16.dp),) {
                    Text(
                        text = "Tags"

                    )
                    Text(text = "Author")
                    Text(text = "Data Added")
                }
            }
        }
        }
}

@Preview
@Composable
fun MainScreenPreview(){
    QuotableTheme {
        DetailContent()
    }
}