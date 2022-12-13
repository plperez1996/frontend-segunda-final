package com.example.frontendsegundofinal.Registro

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.frontendsegundofinal.Clientes.ClientesEntity
import com.example.frontendsegundofinal.Productos.ProductosEntity

@Entity
data class RegistroVentasEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name="fecha")
    val fecha: String,
    @ColumnInfo(name="nroFactura")
    val nroFactura: String,
    @ColumnInfo(name="cliente")
    val cliente: String,
    @ColumnInfo(name="total")
    val total: String,
    @ColumnInfo(name="producto")
    val producto: String)