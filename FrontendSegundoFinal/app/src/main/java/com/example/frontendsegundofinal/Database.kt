package com.example.frontendsegundofinal

import androidx.room.RoomDatabase
import androidx.room.Database
import com.example.frontendsegundofinal.Clientes.ClientesEntity
import com.example.frontendsegundofinal.Productos.ProductosEntity
import com.example.frontendsegundofinal.Registro.RegistroVentasActivity
import com.example.frontendsegundofinal.Registro.RegistroVentasEntity

@Database(
    entities = [ProductosEntity::class, ClientesEntity::class, RegistroVentasEntity::class],
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract fun databaseDAO(): DatabaseDAO
}