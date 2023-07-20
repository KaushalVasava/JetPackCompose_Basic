package com.lahsuak.apps.jetpackcomposebasic.util

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import java.io.InputStreamReader

object AppUtil {
    fun readFileResource(fileName: String): String {
        val inputStream = AppUtil::class.java.getResourceAsStream(fileName)
        val builder = StringBuilder()
        val reader = InputStreamReader(inputStream, Charsets.UTF_8)
        reader.readLines().forEach {
            builder.append(it)
        }
        return builder.toString()
    }

    fun openTab(context: Context, url: String) {
        val packageName = "com.android.chrome"
        val builder = CustomTabsIntent.Builder()
        builder.setShowTitle(true)
        builder.setInstantAppsEnabled(true)
        val customBuilder = builder.build()
        customBuilder.intent.setPackage(packageName)
        customBuilder.launchUrl(context, Uri.parse(url))
    }
}

