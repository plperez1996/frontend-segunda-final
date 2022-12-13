package com.example.frontendsegundofinal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.frontendsegundofinal.Clientes.ClientesEntity
import com.example.frontendsegundofinal.Productos.ProductosEntity
import com.example.frontendsegundofinal.Registro.RegistroVentasEntity

@Dao
interface DatabaseDAO {
    @Query("SELECT * FROM ProductosEntity")
     suspend fun getAllProductos(): List<ProductosEntity>

    @Update
     suspend fun updateProductos(producto: ProductosEntity)

    @Insert
     suspend fun insertProductos(producto: ProductosEntity)

    @Delete
     suspend fun deleteProductos(producto: ProductosEntity)

    @Query("SELECT * FROM ClientesEntity")
     suspend fun getAllClientes(): List<ClientesEntity>

    @Update
     suspend fun updateClientes(cliente: ClientesEntity)

    @Insert
     suspend fun insertClientes(cliente: ClientesEntity)

    @Delete
     suspend fun deleteClientes(cliente: ClientesEntity)

     @Query("SELECT * FROM RegistroVentasEntity")
     suspend fun getAllventas(): List<RegistroVentasEntity>

     @Insert
     suspend fun insertVenta(venta: RegistroVentasEntity)
}