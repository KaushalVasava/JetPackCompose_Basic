package com.lahsuak.apps.jetpackcomposebasic.ui.screen.detailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.lahsuak.apps.jetpackcomposebasic.R
import com.lahsuak.apps.jetpackcomposebasic.model.News
import com.lahsuak.apps.jetpackcomposebasic.util.AppUtil.openTab

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(news: News, navController: NavHostController) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Column {
            TopAppBar(scrollBehavior =
            TopAppBarDefaults.pinnedScrollBehavior(),
                title = {
                    Text(text = "Details screen")
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                })

            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(news.urlToImage)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painter,
                contentDescription = news.title,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = news.title, modifier = Modifier.padding(8.dp), fontSize = 20.sp)
            Text(
                text = news.description,
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = context.getString(R.string.open_for_more),
                style = TextStyle(color = Color.Blue),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable {
                        openTab(context, news.url)
                    }
            )
        }
    }
}

