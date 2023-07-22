package com.lahsuak.apps.jetpackcomposebasic.widget

import android.content.Context
import android.text.format.DateFormat
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.width
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import kotlinx.coroutines.delay

private const val DATE_FORMAT = "hh:mm:ss a"
private const val COUNT_KEY = "count"

object CounterWidget : GlanceAppWidget() {
    val countKey = intPreferencesKey(COUNT_KEY)
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            var date by remember {
                mutableLongStateOf(
                    System.currentTimeMillis()
                )
            }
            val count = currentState(key = countKey) ?: 0
            Column(
                modifier = GlanceModifier
                    .fillMaxSize()
                    .background(Color.DarkGray),
                verticalAlignment = Alignment.Vertical.CenterVertically,
                horizontalAlignment = Alignment.Horizontal.CenterHorizontally
            ) {
                LaunchedEffect(date) {
                    while (true) {
                        delay(1000L)
                        date = System.currentTimeMillis()
                    }
                }
                Text(
                    text = DateFormat.format(DATE_FORMAT, date).toString(),
                    style = TextStyle(color = ColorProvider(Color.White), fontSize = 24.sp)
                )
                Spacer(modifier = GlanceModifier.height(8.dp))
                Text(
                    text = count.toString(),
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        color = ColorProvider(Color.White),
                        fontSize = 26.sp
                    )
                )
                Row {
                    Button(
                        text = "+",
                        onClick = actionRunCallback(IncrementActionCallback::class.java)
                    )
                    Spacer(modifier = GlanceModifier.width(8.dp))
                    Button(
                        text = "-",
                        onClick = actionRunCallback(DecrementActionCallback::class.java)
                    )
                }
            }
        }
    }
}

class CounterWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget
        get() = CounterWidget
}

class IncrementActionCallback : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        updateAppWidgetState(context, glanceId) { prefs ->
            val currentCount = prefs[CounterWidget.countKey]
            if (currentCount != null) {
                prefs[CounterWidget.countKey] = currentCount + 1
            } else {
                prefs[CounterWidget.countKey] = 1
            }
        }
        CounterWidget.update(context, glanceId)
    }
}

class DecrementActionCallback : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        updateAppWidgetState(context, glanceId) { prefs ->
            val currentCount = prefs[CounterWidget.countKey]
            if (currentCount != null) {
                prefs[CounterWidget.countKey] = currentCount - 1
            } else {
                prefs[CounterWidget.countKey] = 1
            }
        }
        CounterWidget.update(context, glanceId)
    }
}