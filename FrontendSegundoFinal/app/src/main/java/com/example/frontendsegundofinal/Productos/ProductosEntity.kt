package com.example.frontendsegundofinal.Productos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductosEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val nombre: String? = "",
    @ColumnInfo(name = "codigo")
    val codigo: String? = "",
    @ColumnInfo(name = "precio")
    val precio: String? = "",
    @ColumnInfo(name = "existencia")
    val existencia: String? = ""
)