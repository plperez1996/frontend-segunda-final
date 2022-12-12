package com.example.frontendsegundofinal

import androidx.room.RoomDatabase
import com.example.frontendsegundofinal.Clientes.ClientesEntity
import com.example.frontendsegundofinal.Productos.ProductosEntity

@androidx.room.Database(
    entities = [ProductosEntity::class, ClientesEntity::class],
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract fun databaseDAO(): DatabaseDAO
}