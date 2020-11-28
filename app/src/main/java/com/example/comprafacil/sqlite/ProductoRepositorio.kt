package com.example.comprafacil.sqlite

import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class ProductoRepositorio (val dao: ProductoDAO){

    private val ejecutador = Executors.newSingleThreadExecutor()

    fun onListaCarrito(): Task<List<Producto>>{
        return Tasks.call(ejecutador, Callable{
            return@Callable dao.listarCarrito()
        })
    }

    suspend fun onInsertaProducto(producto: Producto){
        dao.insertarProducto(producto)
    }

    suspend fun onActualizaProducto(producto: Producto){
        dao.actualizaProducto(producto)
    }

    suspend fun onEliminaProducto(producto: Producto) {
        dao.eliminarProducto(producto)
    }
}