package com.example.frontendsegundofinal

import android.app.Application
import android.content.Context
import androidx.room.Room

class DatabaseApp(context: Context): Application() {
    var context: Context

    init {
        this.context = context
    }

    val room = Room.databaseBuilder(context, Database::class.java, "database").build()
}