package com.example.comprafacil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comprafacil.recycler.ProductoAdapter
import com.example.comprafacil.sqlite.FirebaseCRUD
import com.example.comprafacil.sqlite.Producto
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adaptador : ProductoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = FirebaseCRUD()
        lateinit var lista : ArrayList<Producto>

        db.listarProductos(){ lstProductos ->
            adaptador?.agregarProducto(lstProductos)
            println("CANTIDAD DE ELEMENTOS: ")
        }

        /* SET */
        rvProductos.layoutManager = LinearLayoutManager(this)
        adaptador = ProductoAdapter { }
        rvProductos.adapter = adaptador



    }

}