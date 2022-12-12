package com.example.frontendsegundofinal.Productos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductosEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre: String,
    val codigo: String,
    val precio: String,
    val existencia: String
)