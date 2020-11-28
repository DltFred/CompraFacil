package com.example.comprafacil.sqlite

import androidx.room.*

import androidx.room.*

@Dao
interface ProductoDAO {
    @Query("SELECT * FROM tabla_producto ORDER BY nombre")
    fun listarCarrito() : List<Producto>

    @Insert
    suspend fun insertarProducto(producto: Producto)

    @Update
    fun actualizaProducto(producto: Producto)

    @Delete
    fun eliminarProducto(producto: Producto)
}