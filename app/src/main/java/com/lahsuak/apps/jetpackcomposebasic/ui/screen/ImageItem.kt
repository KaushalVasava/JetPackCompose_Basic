package com.lahsuak.apps.jetpackcomposebasic.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.lahsuak.apps.jetpackcomposebasic.model.ImageModel

@Composable
fun ImageItem(item: ImageModel) {
    AsyncImage(
        model = item.urls.regular,
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}