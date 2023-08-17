package com.lahsuak.apps.jetpackcomposebasic.ui.screen

import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.lahsuak.apps.jetpackcomposebasic.ui.theme.JetPackComposeBasicTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ViewScreen(imageUrl: String, navController: NavController) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Box(Modifier.fillMaxSize()) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                colors = IconButtonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.Black
                )
            ) {
                Icon(Icons.Default.ArrowBack, null)
            }
            OutlinedButton(
                onClick = {
                    setWallpaper(context, imageUrl, coroutineScope)
                },
                colors = ButtonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.Black
                )
            ) {
                Text("Set Wallpaper", color = Color.White)
            }
        }
    }
}

private fun setWallpaper(context: Context, url: String, coroutineScope: CoroutineScope) {
    coroutineScope.launch {
        val wallpaperManager = WallpaperManager.getInstance(context)

        val loader = ImageLoader(context)
        val request = ImageRequest.Builder(context)
            .data(url)
            .allowHardware(false) // Disable hardware bitmaps.
            .build()

        val result = (loader.execute(request) as SuccessResult).drawable
        val image = (result as BitmapDrawable).bitmap

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            wallpaperManager.setBitmap(image, null, true, WallpaperManager.FLAG_SYSTEM)
            wallpaperManager.setWallpaperOffsetSteps(1F, 1F)
        } else {
            wallpaperManager.setBitmap(image)
        }
        Toast.makeText(context, "Wallpaper set!", Toast.LENGTH_SHORT).show()
    }
}

@Preview(showBackground = true)
@Composable
fun ViewScreenPreview() {
    JetPackComposeBasicTheme {
        ViewScreen(
            "", rememberNavController()
        )
    }
}