package com.example.frontendsegundofinal.Clientes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ClientesEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre: String,
    val ruc: String,
    val email: String
)