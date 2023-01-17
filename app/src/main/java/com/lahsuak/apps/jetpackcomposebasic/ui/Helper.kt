package com.lahsuak.apps.jetpackcomposebasic.ui

import java.io.InputStreamReader

object Helper {
    fun readFileResource(fileName: String): String{
        val inputStream = Helper::class.java.getResourceAsStream(fileName)
        val builder = StringBuilder()
        val reader = InputStreamReader(inputStream,Charsets.UTF_8)
        reader.readLines().forEach{
            builder.append(it)
        }
        return builder.toString()
    }
}

