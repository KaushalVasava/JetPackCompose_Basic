package com.lahsuak.apps.jetpackcomposebasic.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.lahsuak.apps.jetpackcomposebasic.R
import com.lahsuak.apps.jetpackcomposebasic.model.News
import com.lahsuak.apps.jetpackcomposebasic.ui.theme.JetPackComposeBasicTheme

@Composable
fun NewsItem(news: News, onClick: () -> Unit) {
    // coil image painter
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(news.urlToImage)
            .placeholder(R.drawable.ic_launcher_foreground)
            .crossfade(true)
            .build(),
        contentScale = ContentScale.FillWidth
    )
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp)
        .clickable {
            onClick()
        }) {
        Column() {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = news.title,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
            Text(
                text = news.description,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
            )
        }
    }
}


@Preview
@Composable
fun NewsItemPreview() {
    JetPackComposeBasicTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NewsItem(
                news = News(
                    "Kaushal",
                    "Ness",
                    "https://pixabay.com/get/gc5bde75f8a92a997aa842681d52d37e41990f5e639497bad55c1cf9921835528340e1269788a027624b201d17734fb431c5269478e54aece4e65f7581452fe98_640.jpg",
                    "https://pixabay.com/get/gc5bde75f8a92a997aa842681d52d37e41990f5e639497bad55c1cf9921835528340e1269788a027624b201d17734fb431c5269478e54aece4e65f7581452fe98_640.jpg",
                )
            ) {}
        }
    }
}