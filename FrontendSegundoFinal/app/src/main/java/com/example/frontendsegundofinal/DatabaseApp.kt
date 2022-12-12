package com.example.frontendsegundofinal

import android.app.Application
import androidx.room.Room

class DatabaseApp: Application() {
    val room = Room.databaseBuilder(this, Database::class.java, "database").build()
}