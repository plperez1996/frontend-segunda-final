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

     @Query("SELECT * FROM ProductosEntity WHERE codigo = :codigo")
     suspend fun getProductByCodigo(codigo: String): ProductosEntity

    @Update
     suspend fun updateProductos(producto: ProductosEntity)

    @Insert
     suspend fun insertProductos(producto: ProductosEntity)

    @Query("DELETE FROM ProductosEntity WHERE codigo = :codigo")
     suspend fun deleteProductos(codigo: String)

    @Query("SELECT * FROM ClientesEntity")
     suspend fun getAllClientes(): List<ClientesEntity>

    @Update
     suspend fun updateClientes(cliente: ClientesEntity)

    @Insert
     suspend fun insertClientes(cliente: ClientesEntity)

     @Query("SELECT * FROM RegistroVentasEntity")
     suspend fun getAllventas(): List<RegistroVentasEntity>

    @Query("SELECT * FROM RegistroVentasEntity WHERE cliente LIKE '%' || :cliente || '%' ")
    suspend fun getVentasByCliente(cliente: String): List<RegistroVentasEntity>

    @Query("SELECT * FROM RegistroVentasEntity WHERE fecha LIKE '%' || :fecha || '%' ")
    suspend fun getVentasByFecha(fecha: String): List<RegistroVentasEntity>

     @Insert
     suspend fun insertVenta(venta: RegistroVentasEntity)

    @Query("DELETE FROM ClientesEntity WHERE ruc = :ruc")
     suspend fun deleteClientes(ruc: String)
}