package com.example.comprafacil.sqlite

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Producto::class], version = 1)
abstract class CarritoDB : RoomDatabase() {

    abstract fun fProductoDAO() : ProductoDAO

    companion object{
        private var INSTANCE : CarritoDB? = null
        fun getInstance(context: Context) : CarritoDB{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this) {
                val newInstance = Room.databaseBuilder(context, CarritoDB::class.java, "Carrito").build()
                INSTANCE = newInstance
                return newInstance
            }
        }
    }
}