package com.lahsuak.apps.jetpackcomposebasic.ui

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

fun openTab(context: Context, url: String) {
    val packageName = "com.android.chrome"
    val builder = CustomTabsIntent.Builder()
    builder.setShowTitle(true)
    builder.setInstantAppsEnabled(true)
    val customBuilder = builder.build()
    customBuilder.intent.setPackage(packageName)
    customBuilder.launchUrl(context, Uri.parse(url))
}